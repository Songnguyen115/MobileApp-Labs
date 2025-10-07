package com.example.checkprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.checkprofile.ui.theme.CheckProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckProfileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CheckProfileScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CheckProfileScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var ageInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Tra cứu thông tin", style = MaterialTheme.typography.titleLarge)

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Họ và tên") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = ageInput,
            onValueChange = { ageInput = it },
            label = { Text("Tuổi") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val age = ageInput.toIntOrNull()
            result = if (age != null) {
                val category = when {
                    age < 2 -> "Em bé "
                    age in 2..10 -> "Trẻ em "
                    age in 10..18 -> "Trẻ vị thành niên "
                    age in 18..64 -> "Người lớn "
                    else -> "Người già "
                }
                "Tên: $name\nTuổi: $age\nPhân loại: $category"
            } else {
                "Không hợp lệ!"
            }
        }) {
            Text("Kiểm tra")
        }

        if (result.isNotEmpty()) {
            Text(text = result, fontSize = 16.sp)
        }
    }
}