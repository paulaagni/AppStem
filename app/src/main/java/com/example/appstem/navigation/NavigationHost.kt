package com.example.appstem.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appstem.screens.BiografiaHypatia
import com.example.appstem.screens.Home
import com.example.appstem.screens.ScrollBios

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.Home.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(AppScreens.Home.route) {
            Home(navController)
        }
        composable(AppScreens.ScrollBios.route) {
            ScrollBios(navController)
        }
        composable(AppScreens.Bio.route) {
            BiografiaHypatia(navController)
        }
    }
}