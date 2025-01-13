package com.example.appstem.screens

// Importaciones necesarias para la creación de la pantalla y los componentes UI.
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appstem.R
import com.example.appstem.model.info
import com.example.appstem.navigation.AppScreens
import com.example.appstem.ui.theme.AppStemTheme


// Pantalla principal que muestra una lista de biografías con una barra de búsqueda
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollBios(navController: NavController) {
    // Estado para almacenar el texto introducido en la barra de búsqueda
    val busquedaBarra = remember { mutableStateOf("") }

    // Tema de la aplicación
    AppStemTheme {
        // Estructura principal de la pantalla con una barra superior (TopAppBar)
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(), // Colores por defecto para la barra
                    title = {
                        // Título de la pantalla dentro de la barra superior
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Biografías")
                        }
                    }
                )
            },
            // Contenido principal de la pantalla
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues) // Padding que respeta la barra superior
                        .padding(start = 16.dp, end = 16.dp, bottom = 90.dp) // Espaciado adicional
                ) {
                    // Campo de texto para la barra de búsqueda
                    TextField(
                        value = busquedaBarra.value, // Texto actual de la búsqueda
                        onValueChange = { busquedaBarra.value = it }, // Acción al cambiar el texto
                        label = { Text("Buscar") }, // Texto de etiqueta dentro del campo
                        leadingIcon = {
                            // Icono de lupa al inicio del campo de texto
                            Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
                        },
                        modifier = Modifier.fillMaxWidth(), // Ocupar todo el ancho disponible
                        shape = RoundedCornerShape(16.dp) // Bordes redondeados del campo de texto
                    )
                    Spacer(modifier = Modifier.height(8.dp)) // Espaciador entre el campo de búsqueda y la lista

                    // Filtrado dinámico de biografías basado en el texto de la barra de búsqueda
                    val filtroBusqueda = info.filter {
                        LocalContext.current.getString(it.name).contains(busquedaBarra.value, ignoreCase = true)
                    }

                    // Lista perezosa para mostrar los elementos filtrados
                    LazyColumn {
                        items(filtroBusqueda) { item ->
                            // Tarjeta para cada elemento de la lista
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth() // La tarjeta ocupa todo el ancho disponible
                                    .padding(8.dp) // Separación entre tarjetas
                                    .clickable {
                                        // Navegar a la biografía de Hypatia si el nombre coincide
                                        if (item.name == R.string.hypatia_de_alejandria)
                                            navController.navigate(route = AppScreens.Bio.route)
                                    },
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Elevación para dar sombra
                                border = BorderStroke(1.dp, Color(0xFFCAC4D0)) // Borde con color claro
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth() // La fila ocupa todo el ancho disponible
                                        .padding(16.dp), // Espaciado interno en la tarjeta
                                    horizontalArrangement = Arrangement.SpaceBetween, // Elementos separados horizontalmente
                                    verticalAlignment = Alignment.CenterVertically // Alineación vertical centrada
                                ) {
                                    Column {
                                        // Nombre del personaje (en negrita y con límite de líneas)
                                        // Nombre del personaje
                                        Text(
                                            text = LocalContext.current.getString(item.name), // Obtener el texto desde el recurso de cadena
                                            fontWeight = FontWeight.Bold,
                                            overflow = TextOverflow.Ellipsis, // Truncar texto si es muy largo
                                            maxLines = 1
                                        )

                                        Text(
                                            text = LocalContext.current.getString(item.profession), // Obtener el texto desde el recurso de cadena
                                            modifier = Modifier.padding(top = 4.dp)
                                        )

                                    }

                                    // Imagen del personaje en formato circular
                                    Image(
                                        painter = painterResource(id = item.imagenId), // Imagen del recurso
                                        contentDescription = null, // Sin descripción
                                        contentScale = ContentScale.Crop, // Ajuste de escala para recortar la imagen
                                        modifier = Modifier
                                            .size(88.dp) // Tamaño fijo para la imagen
                                            .padding(start = 8.dp) // Espaciado a la izquierda
                                            .clip(CircleShape) // Forma circular
                                    )
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}

// Vista previa de la pantalla en modo claro
@Preview(showBackground = true, heightDp = 2000)
@Composable
fun ScrollBiosPreview() {
    AppStemTheme {
        ScrollBios(navController = rememberNavController())
    }
}

// Vista previa de la pantalla en modo oscuro
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ScrollBiosDarkPreview() {
    AppStemTheme {
        ScrollBios(navController = rememberNavController())
    }
}