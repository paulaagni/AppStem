package com.example.appstem.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.appstem.navigation.AppScreens

// Clase sellada (sealed class) que representa los elementos del menú de navegación
// Cada elemento contiene un ícono, un título y una ruta asociada.
sealed class ItemsMenu(
    val icon: ImageVector,  // El ícono que se muestra en la barra de navegación
    val title: String,      // El título del elemento del menú
    val route: String?      // La ruta asociada a la pantalla a la que lleva este ítem (puede ser null si no tiene ruta)
) {
    // Elemento de menú para la pantalla de inicio
    data object Home : ItemsMenu(Icons.Filled.Home, "Inicio", AppScreens.Home.route)

    // Elemento de menú para la pantalla de biografías
    data object ScrollBios : ItemsMenu(Icons.Filled.AccountBox, "Biografías", AppScreens.ScrollBios.route)

    // Elemento de menú para la pantalla de citas
    // Este ítem no tiene ruta asociada, ya que no lleva a una nueva pantalla
    data object Citas : ItemsMenu(Icons.Filled.Create, "Citas", null)

    // Elemento de menú para la pantalla de favoritas
    // Este ítem tampoco tiene ruta asociada
    data object Favoritas : ItemsMenu(Icons.Filled.FavoriteBorder, "Favoritas", null)
}
