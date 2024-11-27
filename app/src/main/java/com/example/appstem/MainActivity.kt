package com.example.appstem

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appstem.ui.theme.AppStemTheme
import com.example.appstem.ItemsMenu.*
import com.example.appstem.navigation.AppScreens
import com.example.appstem.navigation.NavigationHost


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppStemTheme {
                val navController = rememberNavController()
                val navigationItem = listOf(
                    Home,
                    ScrollBios,
                    Citas,
                    Favoritas
                )

                // Comprobar la ruta actual
                val currentRoute = currentRoute(navController)

                Scaffold(
                    bottomBar = {

                        if (currentRoute != AppScreens.Bio.route) {
                            BottomNavigation(navController, navigationItem)
                        }
                    }
                ) {
                    NavigationHost(navController)
                }
            }
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val entrada by navController.currentBackStackEntryAsState()
    return entrada?.destination?.route
}
@Composable
fun BottomNavigation(navController: NavHostController, menuItems: List<ItemsMenu>) {
    BottomAppBar {
        NavigationBar {
            val currentRoute = currentRoute(navController)
            menuItems.forEach { item ->
                NavigationBarItem(
                    icon = { Icon(item.icon, contentDescription = item.title) },
                    label = { Text(text = item.title) },
                    selected = currentRoute == item.route,
                    onClick = {
                        item.route?.let { route ->
                            if (currentRoute != route) {
                                navController.navigate(route)
                            }
                        }
                        // Si route es null, no se hace nada.
                    },
                    alwaysShowLabel = false
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    AppStemTheme {
        val fakeNavController = rememberNavController()
        val fakeMenuItems = listOf(
            Home,
            ScrollBios,
            Citas,
            Favoritas
        )

        AppStemTheme {
            BottomNavigation(navController = fakeNavController, menuItems = fakeMenuItems)
        }
    }
}
