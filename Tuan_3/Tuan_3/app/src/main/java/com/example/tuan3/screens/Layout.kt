package com.example.tuan3.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.background
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.navigation.NavController

@Composable
fun Layout(navController: NavController) {
    var flag by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "LAYOUT",
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
                // Column
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
                            text = "Column",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Sắp xếp theo chiều dọc",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }

                // Row
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
                            text = "Row",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Sắp xếp theo chiều ngang",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }

                // Box
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                        .clickable { flag = 3 },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFB0E3F4),
                        contentColor = Color.Black
                    ),
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Box",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Xếp chồng các phần tử",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }
            }
        } else if (flag == 1) {
            // Column
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
                ) {
                    Text(
                        text = "Column",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 34.sp
                    )
                }
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text(
                    text = "Basic",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Column {
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Red))
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Yellow))
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Blue))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Khoảng cách",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Red))
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Yellow))
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Blue))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Căn giữa",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Red))
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Yellow))
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Blue))
                }
            }

        } else if (flag == 2) {
            // Row
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
                ) {
                    Text(
                        text = "Row",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 34.sp
                    )
                }
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text(
                    text = "Basic",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Red))
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Yellow))
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Blue))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Khoảng cách",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Red))
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Yellow))
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Blue))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Căn giữa",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Red))
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Yellow))
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Blue))
                }
            }

        } else if (flag == 3) {
            // Box
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
                ) {
                    Text(
                        text = "Box",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 34.sp
                    )
                }
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text(
                    text = "Basic",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Box(modifier = Modifier.size(100.dp)) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(Color.Red)
                            .align(Alignment.TopStart)
                    )
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(Color.Yellow)
                            .align(Alignment.Center)
                    )
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(Color.Blue)
                            .align(Alignment.BottomEnd)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "ContentAlignment",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Yellow))
                }
            }
        }
    }
}