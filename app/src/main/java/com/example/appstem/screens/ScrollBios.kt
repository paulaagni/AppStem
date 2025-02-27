package com.example.appstem.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appstem.R
import com.example.appstem.ui.theme.AppStemTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollBios(
    navController: NavController,
    // El ViewModel se obtiene con un factory personalizado, para poder inyectar dependencias
    viewModel: ScrollBiosViewModel = viewModel(factory = ScrollBiosViewModel.factory)
) {
    // Observamos el valor de búsqueda y la lista filtrada en tiempo real
    val searchQuery by viewModel.searchQuery.collectAsState()
    val biosList by viewModel.filteredBios.collectAsState()

    // Aplicamos el tema definido en la app
    AppStemTheme {
        // Scaffold proporciona una estructura básica de pantalla con barra superior, contenido, etc.
        Scaffold(
            topBar = {
                // Barra superior (TopAppBar) con título simple
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(),
                    title = { Text("Biografías") }
                )
            },
            content = { paddingValues ->
                // Column principal que alberga la barra de búsqueda y la lista
                Column(
                    modifier = Modifier
                        // Se añaden márgenes correspondientes al content de Scaffold
                        .padding(paddingValues)
                        // Márgenes adicionales en la pantalla
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    // Campo de texto para introducir la búsqueda
                    TextField(
                        value = searchQuery,
                        onValueChange = { viewModel.onSearchQueryChanged(it) },
                        label = { Text("Buscar") },
                        leadingIcon = {
                            // Icono de la lupa
                            Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp) // Esquinas redondeadas
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // LazyColumn para mostrar la lista de biografías
                    // contentPadding define un relleno adicional en la parte inferior
                    LazyColumn(
                        contentPadding = PaddingValues(bottom = 64.dp)
                    ) {
                        // Iteramos sobre la lista de biografías y construimos cada ítem
                        items(biosList) { bio ->
                            // Cada biografía se muestra en una tarjeta (Card)
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .clickable {
                                        // Al hacer clic en la tarjeta, navegamos a la pantalla de detalles
                                        val index = biosList.indexOf(bio)
                                        navController.navigate("bio_screen/$index")
                                    },
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                // Borde para dar realce visual
                                border = BorderStroke(1.dp, Color(0xFFCAC4D0))
                            ) {
                                // Disposición en fila para texto a la izquierda e imagen a la derecha
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    // Columna para el nombre y profesión
                                    Column(
                                        modifier = Modifier.weight(1f) // Asigna peso para ocupar más espacio que la imagen
                                    ) {
                                        // Nombre de la científica
                                        Text(
                                            text = bio.nombre,
                                            fontWeight = FontWeight.Bold,
                                            overflow = TextOverflow.Ellipsis,
                                            maxLines = 1
                                        )
                                        // Profesión de la científica
                                        Text(
                                            text = bio.profesion,
                                            modifier = Modifier.padding(top = 4.dp),
                                            overflow = TextOverflow.Ellipsis,
                                            maxLines = 2
                                        )
                                    }

                                    // Se obtiene el id del recurso drawable a partir del nombre almacenado
                                    val context = LocalContext.current
                                    val resourceId = context.resources.getIdentifier(
                                        bio.imageResName,
                                        "drawable",
                                        context.packageName
                                    )

                                    // Imagen mostrada a la derecha
                                    Image(
                                        painter = painterResource(
                                            // Si no encuentra el recurso, usa una imagen placeholder
                                            id = if (resourceId != 0) resourceId else R.drawable.placeholder_image
                                        ),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(88.dp)    // Fija el tamaño de la imagen
                                            .padding(start = 8.dp)
                                            .clip(CircleShape)  // Recorta la imagen en forma circular
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

// Vista previa en modo claro, con altura extendida para ver más contenido
@Preview(showBackground = true, heightDp = 2000)
@Composable
fun ScrollBiosPreview() {
    // NavController de prueba para la previsualización
    AppStemTheme {
        ScrollBios(navController = rememberNavController())
    }
}

// Vista previa en modo oscuro
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ScrollBiosDarkPreview() {
    AppStemTheme {
        ScrollBios(navController = rememberNavController())
    }
}
