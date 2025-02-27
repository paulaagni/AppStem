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

/**
 * NavigationHost administra las rutas de navegación y define los destinos en la aplicación.
 * Se basa en el NavController, que permite cambiar entre composables (pantallas) de manera declarativa.
 */
@Composable
fun NavigationHost(navController: NavHostController) {
    // NavHost marca el punto de entrada de la navegación y especifica la pantalla inicial (startDestination).
    NavHost(
        navController = navController,
        startDestination = AppScreens.Splash.route,
        modifier = Modifier.fillMaxSize()
    ) {
        // Destino para la pantalla de Splash. Al terminar, navega a la pantalla Home.
        composable(AppScreens.Splash.route) {
            SplashScreen(onSplashFinished = {
                navController.navigate(AppScreens.Home.route)
            })
        }

        // Composable para la pantalla principal (Home).
        composable(AppScreens.Home.route) {
            Home()
        }

        // Ruta que muestra la lista de biografías.
        composable(AppScreens.ScrollBios.route) {
            ScrollBios(navController)
        }

        // Definición de ruta con argumento ("bioIndex") para mostrar la biografía seleccionada.
        // navArgument("bioIndex") se define como tipo Int.
        composable(
            route = "bio_screen/{bioIndex}",
            arguments = listOf(navArgument("bioIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            // Extraemos el valor de "bioIndex" de los argumentos del stack de navegación.
            val bioIndex = backStackEntry.arguments?.getInt("bioIndex") ?: 0
            BioScreen(navController, bioIndex)
        }

        // Ruta para la lista de citas.
        composable(AppScreens.ScrollCitas.route) {
            ScrollCitas(navController)
        }

        // Definición de ruta con argumento ("bioIndex") para mostrar la cita seleccionada.
        composable(
            route = "cita_screen/{bioIndex}",
            arguments = listOf(navArgument("bioIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val bioIndex = backStackEntry.arguments?.getInt("bioIndex") ?: 0
            CitaScreen(navController, bioIndex)
        }

        // Ruta para la pantalla de información, sin argumentos adicionales.
        composable(AppScreens.Info.route) {
            Info() // Ahora se navega correctamente a la pantalla de información
        }
    }
}
