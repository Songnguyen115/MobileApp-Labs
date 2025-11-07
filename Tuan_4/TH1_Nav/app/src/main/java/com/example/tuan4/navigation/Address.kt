package com.example.tuan3.navigation

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.tuan3.screens.BTVN1
import com.example.tuan3.screens.Home
import com.example.tuan3.screens.Mot


@Composable
fun Address(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = "btvn1"
    ) {
        composable("btvn1") { BTVN1(navController = navController) }
        composable("home") { Home(navController = navController) }
        composable("mot") { Mot(navController = navController) }
    }
}