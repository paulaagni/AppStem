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

/**
 * MainActivity es la actividad principal de la app, que define la interfaz y la navegación.
 */
class MainActivity : ComponentActivity() {
    /**
     * Se suprime la advertencia de uso del Scaffold, pues estamos controlando
     * intencionalmente el padding en el contenido (Scaffold).
     */
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent establece la composición (UI) de Jetpack Compose como contenido de la actividad.
        setContent {
            // Se aplica el tema de la aplicación.
            AppStemTheme {
                // Se crea el NavController, que maneja la navegación entre pantallas.
                val navController = rememberNavController()

                // Lista de ítems que se mostrarán en la barra de navegación inferior.
                val navigationItem = listOf(
                    Home,
                    ScrollBios,
                    ScrollCitas,
                    Info
                )

                // Se obtiene la ruta actual (pantalla en la que está el usuario).
                val currentRoute = currentRoute(navController)

                // Scaffold proporciona una estructura con elementos como barra superior o inferior.
                Scaffold(
                    // Definimos la BottomBar, pero solo cuando no estemos en Splash o BioScreen.
                    bottomBar = {
                        if (currentRoute != AppScreens.Splash.route && currentRoute != AppScreens.Bio.route) {
                            BottomNavigation(navController, navigationItem)
                        }
                    }
                ) {
                    // NavigationHost es el contenedor principal que renderiza las pantallas
                    // basadas en la ruta o destino actual del NavController.
                    NavigationHost(navController)
                }
            }
        }
    }
}

/**
 * currentRoute() devuelve la ruta (route) actual de la pila de navegación.
 */
@Composable
fun currentRoute(navController: NavHostController): String? {
    // currentBackStackEntryAsState expone el estado de la ruta actual en la navegación.
    val entrada by navController.currentBackStackEntryAsState()
    // De la entrada, obtenemos la ruta del destino.
    return entrada?.destination?.route
}

/**
 * BottomNavigation crea la barra de navegación inferior con NavigationBar de Material3.
 * Recibe el NavController para navegar y una lista de ItemsMenu con icono y título.
 */
@Composable
fun BottomNavigation(navController: NavHostController, menuItems: List<ItemsMenu>) {
    AppStemTheme {
        // BottomAppBar se utiliza como contenedor para la barra de navegación inferior.
        BottomAppBar {
            // NavigationBar para colocar los NavigationBarItem (elementos de la barra).
            NavigationBar {
                // Determinamos la ruta actual para marcar como seleccionado el ítem adecuado.
                val currentRoute = currentRoute(navController)

                // Recorremos cada ítem del menú para mostrarlo en la barra.
                menuItems.forEach { item ->
                    NavigationBarItem(
                        // icon e label definen la apariencia de cada botón en la barra.
                        icon = { Icon(item.icon, contentDescription = item.title) },
                        label = { Text(text = item.title) },
                        // selected se basa en si la ruta actual coincide con la del ítem.
                        selected = currentRoute == item.route,
                        // onClick navega a la ruta del ítem si no está ya en ella.
                        onClick = {
                            item.route?.let { route ->
                                if (currentRoute != route) {
                                    navController.navigate(route)
                                }
                            }
                        },
                        // alwaysShowLabel indica si se muestra el texto incluso cuando no está seleccionado.
                        alwaysShowLabel = false
                    )
                }
            }
        }
    }
}

/**
 * Vista previa del diseño (para fines de desarrollo y pruebas),
 * muestra la barra de navegación con un NavController ficticio.
 */
@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    AppStemTheme {
        // Se crea un NavController ficticio para la previsualización en el IDE.
        val fakeNavController = rememberNavController()
        // Lista de ítems ficticios para mostrar en la vista previa.
        val fakeMenuItems = listOf(
            Home,
            ScrollBios,
            ScrollCitas,
            Info
        )

        // Se llama a BottomNavigation con estos datos ficticios.
        BottomNavigation(navController = fakeNavController, menuItems = fakeMenuItems)
    }
}
