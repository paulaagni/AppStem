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
import com.example.appstem.model.ItemsMenu
import com.example.appstem.ui.theme.AppStemTheme
import com.example.appstem.model.ItemsMenu.*
import com.example.appstem.navigation.AppScreens
import com.example.appstem.navigation.NavigationHost


// Actividad principal de la aplicación
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aplicar el tema personalizado de la app
            AppStemTheme {
                val navController = rememberNavController() // Controlador para la navegación
                val navigationItem = listOf(
                    Home, // Elemento de navegación para la pantalla Home
                    ScrollBios, // Elemento de navegación para la lista de biografías
                    Citas, // Elemento de navegación para citas
                    Favoritas // Elemento de navegación para favoritas
                )

                // Obtener la ruta actual de navegación
                val currentRoute = currentRoute(navController)

                Scaffold(
                    bottomBar = {
                        // Mostrar la barra de navegación solo si la ruta actual no es "Bio"
                        if (currentRoute != AppScreens.Bio.route) {
                            BottomNavigation(navController, navigationItem)
                        }
                    }
                ) {
                    // Host de navegación para controlar las pantallas de la app
                    NavigationHost(navController)
                }
            }
        }
    }
}

// Función para obtener la ruta actual desde el NavController
@Composable
fun currentRoute(navController: NavHostController): String? {
    val entrada by navController.currentBackStackEntryAsState() // Observar el estado actual
    return entrada?.destination?.route // Devolver la ruta actual
}

// Barra de navegación en la parte inferior de la pantalla
@Composable
fun BottomNavigation(navController: NavHostController, menuItems: List<ItemsMenu>) {
    AppStemTheme {
        BottomAppBar {
            NavigationBar {
                val currentRoute = currentRoute(navController) // Obtener la ruta actual
                menuItems.forEach { item ->
                    // Crear un elemento de la barra de navegación por cada ítem del menú
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.title) }, // Ícono del ítem
                        label = { Text(text = item.title) }, // Etiqueta del ítem
                        selected = currentRoute == item.route, // Seleccionado si coincide con la ruta actual
                        onClick = {
                            item.route?.let { route ->
                                // Navegar a la nueva ruta solo si no es la actual
                                if (currentRoute != route) {
                                    navController.navigate(route)
                                }
                            }
                        },
                        alwaysShowLabel = false // Ocultar etiqueta si no está seleccionada
                    )
                }
            }
        }
    }
}

// Vista previa del diseño para propósitos de desarrollo
@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    AppStemTheme {
        val fakeNavController = rememberNavController() // Controlador de navegación ficticio
        val fakeMenuItems = listOf(
            Home, // Ítem ficticio Home
            ScrollBios, // Ítem ficticio de biografías
            Citas, // Ítem ficticio de citas
            Favoritas // Ítem ficticio de favoritas
        )

        // Mostrar la barra de navegación con datos ficticios
        BottomNavigation(navController = fakeNavController, menuItems = fakeMenuItems)
    }
}