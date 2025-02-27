package com.example.appstem.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appstem.screens.*

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.Splash.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(AppScreens.Splash.route) {
            SplashScreen(onSplashFinished = {
                navController.navigate(AppScreens.Home.route)
            })
        }

        composable(AppScreens.Home.route) { Home() }
        composable(AppScreens.ScrollBios.route) { ScrollBios(navController) }

        composable(
            route = "bio_screen/{bioIndex}",
            arguments = listOf(navArgument("bioIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val bioIndex = backStackEntry.arguments?.getInt("bioIndex") ?: 0
            BioScreen(navController, bioIndex)
        }

        composable(AppScreens.ScrollCitas.route) { ScrollCitas(navController) }

        composable(
            route = "cita_screen/{bioIndex}",
            arguments = listOf(navArgument("bioIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val bioIndex = backStackEntry.arguments?.getInt("bioIndex") ?: 0
            CitaScreen(navController, bioIndex)
        }

        composable(AppScreens.Info.route) {
            Info() // Ahora se navega correctamente a la pantalla de información
        }
    }
}
