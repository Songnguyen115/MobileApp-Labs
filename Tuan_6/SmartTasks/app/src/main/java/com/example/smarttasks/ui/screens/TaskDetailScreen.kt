package com.example.smarttasks.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.smarttasks.data.model.Task
import com.example.smarttasks.data.repository.TaskRepository
import kotlinx.coroutines.launch
import androidx.compose.ui.unit.dp


@Composable
fun TaskDetailScreen(navController: NavController, id: Int) {
    val repo = TaskRepository()
    var task by remember { mutableStateOf<Task?>(null) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(id) {
        scope.launch {
            val response = repo.getTaskDetail(id)
            if (response.isSuccessful) task = response.body()
        }
    }

    task?.let { t ->
        Column(modifier = Modifier.padding(16.dp)) {
            Text(t.title, style = MaterialTheme.typography.headlineSmall)
            Text(t.description)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Category: ${t.category}")
            Text("Status: ${t.status}")
            Text("Priority: ${t.priority}")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                    repo.deleteTask(id)
                    navController.popBackStack()
                }
            }) {
                Text("Delete Task")
            }
        }
    } ?: run {
        Text("Loading...")
    }
}
