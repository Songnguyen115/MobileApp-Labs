package com.example.taoso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taoso.ui.theme.TaoSoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaoSoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaoSoScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TaoSoScreen(modifier: Modifier = Modifier) {
    var input by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }
    var numbers by remember { mutableStateOf(listOf<Int>()) }

    Column(
        modifier = modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tạo Số", fontSize = 24.sp)

        TextField(
            value = input,
            onValueChange = {
                input = it
                error = false
            },
            label = { Text("Nhập số") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val number = input.toIntOrNull()
            if (number != null && number > 0) {
                numbers = (1..number).toList()
                error = false
            } else {
                numbers = emptyList()
                error = true
            }
        }) {
            Text("Tạo")
        }

        if (error) {
            Text(
                text = "→ Số liệu bạn nhập không hợp lệ",
                color = MaterialTheme.colorScheme.error
            )
        }


        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            numbers.forEach {
                Button(onClick = { /* xử lý khi nhấn */ }) {
                    Text(text = "$it")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaoSoPreview() {
    TaoSoTheme {
        TaoSoScreen()
    }
}