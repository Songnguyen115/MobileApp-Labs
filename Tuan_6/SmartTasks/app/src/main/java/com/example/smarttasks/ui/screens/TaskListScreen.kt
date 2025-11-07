package com.example.smarttasks.ui.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.smarttasks.data.repository.TaskRepository
import kotlinx.coroutines.launch

@Composable
fun TaskListScreen(navController: NavController) {
    val repo = TaskRepository()
    var tasks by remember { mutableStateOf(listOf<com.example.smarttasks.data.model.Task>()) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            val response = repo.getTasks()
            if (response.isSuccessful) {
                tasks = response.body() ?: emptyList()
            }
        }
    }

    if (tasks.isEmpty()) {
        EmptyView()
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            items(tasks.size) { index ->
                val task = tasks[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            navController.navigate("detail/${task.id}")
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(task.title, style = MaterialTheme.typography.titleMedium)
                        Text("Status: ${task.status}")
                        Text("Date: ${task.date}")
                    }
                }
            }
        }
    }
}
