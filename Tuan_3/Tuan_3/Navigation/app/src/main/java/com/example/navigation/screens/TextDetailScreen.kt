package com.example.navigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextDetailScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("The quick ", fontSize = 20.sp)
        Text("Brown fox", fontWeight = FontWeight.Bold, color = Color.Blue)
        Text("j u m p s", letterSpacing = 4.sp, fontStyle = FontStyle.Italic)
        Text("over the lazy dog.", fontSize = 18.sp, color = Color.Gray)
    }
}