package com.example.appstem.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appstem.screens.Home
import com.example.appstem.screens.ScrollBios
import com.example.appstem.screens.BiografiaHypatia

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Home.route) {
        composable(route = AppScreens.Home.route) {
            Home(navController)
        }
        composable(route = AppScreens.ScrollBios.route) {
            ScrollBios(navController)
        }
        composable(route = AppScreens.Bio.route) {
            BiografiaHypatia(navController)
        }

    }
}

