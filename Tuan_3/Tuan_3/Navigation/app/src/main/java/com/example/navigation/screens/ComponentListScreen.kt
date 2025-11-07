package com.example.navigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ComponentListScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("UI Components List", style = MaterialTheme.typography.titleLarge)

        Text("Display text")
        Text("Hello Jetpack Compose!")

        Spacer(Modifier.height(8.dp))
        Text("Display image")
        Image(
            painter = painterResource(id = R.drawable.uth),
            contentDescription = "UTH",
            modifier = Modifier.height(100.dp)
        )

        Spacer(Modifier.height(8.dp))
        Text("Display button")
        Button(onClick = {}) { Text("Click me") }

        Spacer(Modifier.height(8.dp))
        Text("Display textfield")
        var text by remember { mutableStateOf("") }
        TextField(value = text, onValueChange = { text = it })

        Spacer(Modifier.height(8.dp))
        Text("Display switch")
        var checked by remember { mutableStateOf(false) }
        Switch(checked = checked, onCheckedChange = { checked = it })

        Spacer(Modifier.height(8.dp))
        Text("Display progressbar")
        LinearProgressIndicator(progress = 0.5f)

        Spacer(Modifier.height(8.dp))
        Text("Arrange vertically")
        Column {
            Text("Item 1")
            Text("Item 2")
        }

        Spacer(Modifier.height(8.dp))
        Text("Arrange horizontally")
        Row {
            Text("Left")
            Spacer(Modifier.width(8.dp))
            Text("Right")
        }

        Spacer(Modifier.height(16.dp))
        Button(onClick = { navController.navigate("textDetail") }) {
            Text("Go to styled text")
        }
    }
}