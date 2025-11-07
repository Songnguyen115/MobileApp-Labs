package com.example.myapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyFirstAppScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyFirstAppScreen(modifier: Modifier = Modifier) {
    var message by remember { mutableStateOf("Hello") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My First App",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = message,
            fontSize = 18.sp,
            fontWeight = if (message.contains("Nguyen")) FontWeight.Bold else FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(40.dp))


        Button(onClick = {
            message = "I'm Phạm Song Đức Nguyên "
        }) {
            Text(text = "Say Hi!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyFirstAppPreview() {
    MyAppTheme {
        MyFirstAppScreen()
    }
}