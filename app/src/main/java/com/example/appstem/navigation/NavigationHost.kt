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
import com.example.appstem.ui.theme.AppStemTheme

// Función Composable que configura el host de navegación para la aplicación.
@Composable
fun NavigationHost(navController: NavHostController) {
    // Establece el tema de la aplicación (AppStemTheme) para la navegación.
    AppStemTheme {
        // Define el NavHost, que maneja la navegación entre diferentes pantallas.
        NavHost(
            navController = navController, // Controlador de navegación
            startDestination = AppScreens.Home.route, // Pantalla inicial
            modifier = Modifier.fillMaxSize() // Modificador para que ocupe todo el tamaño disponible
        ) {
            // Define las rutas de navegación para las pantallas de la aplicación.
            composable(AppScreens.Home.route) {
                // Pantalla de inicio (Home)
                Home(navController) // Llama a la función Home pasando el navController
            }
            composable(AppScreens.ScrollBios.route) {
                // Pantalla de biografías (ScrollBios)
                ScrollBios(navController) // Llama a la función ScrollBios pasando el navController
            }
            composable(AppScreens.Bio.route) {
                // Pantalla de biografía de Hypatia (Bio)
                BiografiaHypatia(navController) // Llama a la función BiografiaHypatia pasando el navController
            }
        }
    }
}
