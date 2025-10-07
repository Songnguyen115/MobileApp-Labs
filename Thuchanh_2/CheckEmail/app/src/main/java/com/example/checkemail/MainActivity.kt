package com.example.checkemail

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
import com.example.checkemail.ui.theme.CheckEmailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckEmailTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CheckEmailScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CheckEmailScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Check Email", fontSize = 24.sp)

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            result = when {
                email.isBlank() -> "Email không hợp lệ"
                !email.contains("@") -> "Email không đúng định dạng"
                else -> "Email hợp lệ"
            }
        }) {
            Text("Check")
        }

        if (result.isNotEmpty()) {
            Text(text = result, color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckEmailPreview() {
    CheckEmailTheme {
        CheckEmailScreen()
    }
}