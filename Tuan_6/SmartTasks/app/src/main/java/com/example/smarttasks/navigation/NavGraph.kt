package com.example.smarttasks.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smarttasks.ui.screens.TaskListScreen
import com.example.smarttasks.ui.screens.TaskDetailScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "list") {
        composable("list") { TaskListScreen(navController) }
        composable("detail/{id}") { backStack ->
            val id = backStack.arguments?.getString("id")?.toInt() ?: 0
            TaskDetailScreen(navController, id)
        }
    }
}
