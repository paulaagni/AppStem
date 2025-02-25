package com.example.appstem.navigation

// Clase sellada (sealed class) que define las pantallas de la aplicación
// Cada pantalla tiene una ruta asociada, que es una cadena de texto utilizada para la navegación.
sealed class AppScreens(val route: String) {
    // Pantalla de inicio (home_screen)
    data object Home : AppScreens("home_screen")

    // Pantalla de biografías (scrollbios_screen)
    data object ScrollBios : AppScreens("scrollbios_screen")

    // Pantalla de biografía individual (bio_screen)
    data object Bio : AppScreens("bio_screen")

    data object Splash : AppScreens("splash_screen")

    data object ScrollCitas: AppScreens("scrollcitas_screen")

    data object Cita: AppScreens("cita_screen")
}
