package com.example.appstem.navigation

sealed class AppScreens(val route: String) {
    data object Home: AppScreens("home_screen")
    data object ScrollBios: AppScreens("scrollbios_screen")
    data object Bio: AppScreens("Bio_screen")
}