package com.example.appstem.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.appstem.navigation.AppScreens

sealed class ItemsMenu(
    val icon: ImageVector,
    val title: String,
    val route: String?
) {
    data object Home: ItemsMenu(Icons.Filled.Home, "Inicio", AppScreens.Home.route)
    data object ScrollBios: ItemsMenu(Icons.Filled.AccountBox, "Biografías", AppScreens.ScrollBios.route)
    data object Citas: ItemsMenu(Icons.Filled.Create, "Citas", null) // No tiene ruta
    data object Favoritas: ItemsMenu(Icons.Filled.FavoriteBorder, "Favoritas", null) // No tiene ruta
}
