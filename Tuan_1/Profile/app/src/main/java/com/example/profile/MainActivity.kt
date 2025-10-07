package com.example.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.ui.theme.ProfileTheme
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    var name by remember { mutableStateOf("Pham Song Duc Nguyen") }
    var location by remember { mutableStateOf("Ben Tre, Viet Nam") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar tròn
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(value = name, onValueChange = { name = it }, label = { Text("Tên") })
            TextField(value = location, onValueChange = { location = it }, label = { Text("Địa chỉ") })
        }

        IconButton(
            onClick = { /* chức năng gọi */ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(64.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Call",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}