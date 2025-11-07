package com.example.librarymanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.librarymanagement.ui.theme.LibraryManagementTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LibraryManagementTheme {
                LibraryScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen() {
    var studentName by remember { mutableStateOf("Pham Song Duc Nguyen") }
    var newName by remember { mutableStateOf("") }
    var bookList by remember { mutableStateOf(emptyList<String>()) }
    var newBook by remember { mutableStateOf("") }
    var showNameField by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.height(120.dp),
                title = {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Hệ thống",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineLarge
                        )
                        Text(
                            text = "Quản Lý Thư Viện",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Default.List, contentDescription = null) },
                    label = { Text("Quản lý") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(Icons.Default.Add, contentDescription = null) },
                    label = { Text("Thêm") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(Icons.Default.Info, contentDescription = null) },
                    label = { Text("Thông tin") }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Sinh viên + Thay đổi
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Sinh viên: $studentName", style = MaterialTheme.typography.titleMedium)
                Button(onClick = {
                    showNameField = !showNameField
                }) {
                    Text("Thay đổi")
                }
            }

            if (showNameField) {
                OutlinedTextField(
                    value = newName,
                    onValueChange = { newName = it },
                    label = { Text("Nhập tên mới") },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = {
                        if (newName.isNotBlank()) {
                            studentName = newName
                            newName = ""
                            showNameField = false // Ẩn lại sau khi đổi tên
                        }
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Xác nhận")
                }
            }



            Text(text = "Danh sách sách đã mượn:", style = MaterialTheme.typography.titleMedium)
            if (bookList.isEmpty()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Bạn chưa mượn quyền sách nào",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Nhấn 'Thêm' để bắt đầu hành trình đọc sách!",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            LazyColumn {
                items(bookList) { book ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Text(
                            text = book,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }

            OutlinedTextField(
                value = newBook,
                onValueChange = { newBook = it },
                label = { Text("Thêm sách") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = {
                if (newBook.isNotBlank()) {
                    bookList = bookList + newBook
                    newBook = ""
                }
            }, modifier = Modifier.align(Alignment.End)) {
                Text("Thêm")
            }
        }
    }
}