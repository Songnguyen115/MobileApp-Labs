package com.example.tuan3.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.navigation.NavController
import com.example.tuan3.R

@Composable
fun Display(navController: NavController) {
    var flag by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // CĂN GIỮA NGANG
    ) {
        Text(
            "Display",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Cyan,
            modifier = Modifier.clickable {
                navController.navigate("home")
            }
        )
        if (flag == 0) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                // TEXT
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                        .clickable { flag = 1 },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFB0E3F4),
                        contentColor = Color.Black
                    ),
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Text",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                // IMAGE
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                        .clickable { flag = 2 },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFB0E3F4),
                        contentColor = Color.Black
                    ),
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Image",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        } else if (flag == 1) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .clickable { flag = 0 },
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFB0E3F4),
                    contentColor = Color.Black
                ),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "Text",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 34.sp
                    )
                }
            }

            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Text(
                    text = "Bài tập về nhà tuần 3",
                    fontSize = 24.sp
                )
                Text(
                    text = "Làm bài thực hành 1",
                    fontSize = 16.sp
                )
                Text(
                    text = "Làm bài thực hành 2",
                    fontSize = 16.sp
                )
                Text(
                    text = "Cố gắng làm đc UI bài 1 như thầy đã gửi",
                    fontSize = 16.sp
                )
            }
        } else if (flag == 2) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .clickable { flag = 0 },
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFB0E3F4),
                    contentColor = Color.Black
                ),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "Image",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 34.sp
                    )
                }
            }
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Image(
                    painter = painterResource(id = R.drawable.jetpack_compose),
                    contentDescription = "Mô tả hình ảnh",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Jetpack Compose",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                )

                Image(
                    painter = painterResource(id = R.drawable.uth),
                    contentDescription = "Mô tả hình ảnh",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "UTH",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                )

                Image(
                    painter = painterResource(id = R.drawable.logouth),
                    contentDescription = "Mô tả hình ảnh",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Logo UTH",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                )

                Image(
                    painter = painterResource(id = R.drawable.androidlogo),
                    contentDescription = "Mô tả hình ảnh",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Logo Android",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                )
                Text(text = "\n\n")
            }
        }
    }
}