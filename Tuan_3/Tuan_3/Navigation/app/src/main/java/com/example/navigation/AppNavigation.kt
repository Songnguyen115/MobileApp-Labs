package com.example.navigation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "welcome", modifier = modifier) {
        composable("welcome") {
            WelcomeScreen { navController.navigate("components") }
        }
        composable("components") {
            ComponentListScreen(navController)
        }
        composable("textDetail") { TextDetailScreen() }
        composable("images") { ImageScreen() }
        composable("textField") { TextFieldScreen() }
        composable("passwordField") { PasswordFieldScreen() }
        composable("rowLayout") { RowLayoutScreen() }
    }
}