package com.example.myprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myprofile.ui.theme.MyProfileTheme
import androidx.compose.material3.HorizontalDivider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyProfileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EditableProfileScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EditableProfileScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("Phạm Song Đức Nguyên") }
    var phone by remember { mutableStateOf("083205002183") }
    var orientation by remember { mutableStateOf("...") }

    Column(
        modifier = modifier
            .padding(24.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Avatar tròn
        Image(
            painter = painterResource(id = R.drawable.avatar), // dùng ảnh avatar nếu đã thêm vào drawable
            contentDescription = "Avatar",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        // Các ô nhập liệu có thể chỉnh sửa
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Họ và tên") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Số điện thoại") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = orientation,
            onValueChange = { orientation = it },
            label = { Text("ĐMong muốn và định hướng của bạn là gì sau khi học xong môn học?") },
            modifier = Modifier.fillMaxWidth()
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    MyProfileTheme {
        EditableProfileScreen()
    }
}