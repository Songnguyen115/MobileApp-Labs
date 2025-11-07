package com.example.navigation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.navigation.R

@Composable
fun ImageScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("UTH")
        Image(painter = painterResource(id = R.drawable.uth), contentDescription = "UTH")
        Spacer(modifier = Modifier.height(16.dp))
        Text("In app")
        Image(painter = painterResource(id = R.drawable.in_app), contentDescription = "In app")
    }
}