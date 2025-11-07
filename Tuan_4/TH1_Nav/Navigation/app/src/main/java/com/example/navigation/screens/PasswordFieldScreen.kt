package com.example.navigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun PasswordFieldScreen() {
    var password by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Nhập mật khẩu") },
            visualTransformation = PasswordVisualTransformation()
        )
    }
}