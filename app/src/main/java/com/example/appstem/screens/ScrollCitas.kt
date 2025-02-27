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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appstem.R
import com.example.appstem.ui.theme.AppStemTheme

/**
 * ScrollCitas muestra una lista de citas asociadas a las científicas,
 * similar a ScrollBios pero enfocada en la frase o cita (bio.cita).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollCitas(
    navController: NavController,
    // Se obtiene el mismo ViewModel que gestiona la búsqueda y filtrado de científicas.
    viewModel: ScrollBiosViewModel = viewModel(factory = ScrollBiosViewModel.factory)
) {
    // Observamos los valores de búsqueda y la lista filtrada en tiempo real.
    val searchQuery by viewModel.searchQuery.collectAsState()
    val biosList by viewModel.filteredBios.collectAsState()

    // Aplicamos el tema definido en la app.
    AppStemTheme {
        // Scaffold proporciona estructura básica con barra superior (TopAppBar) y contenido.
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(),
                    title = { Text("Citas") }
                )
            },
            content = { paddingValues ->
                // Column principal para albergar la barra de búsqueda y la lista de citas.
                Column(
                    modifier = Modifier
                        .padding(paddingValues) // Margen que viene de Scaffold
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    // Campo de texto para buscar.
                    TextField(
                        value = searchQuery,
                        onValueChange = { viewModel.onSearchQueryChanged(it) },
                        label = { Text("Buscar") },
                        leadingIcon = {
                            // Icono de búsqueda.
                            Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp) // Esquinas redondeadas.
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // LazyColumn que muestra las citas de cada científica.
                    // contentPadding define un relleno en la parte inferior (bottom = 64.dp).
                    LazyColumn(
                        contentPadding = PaddingValues(bottom = 64.dp)
                    ) {
                        // Iteramos sobre la lista filtrada de biografías.
                        items(biosList) { bio ->
                            // Cada ítem se muestra en una Card cliqueable.
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .clickable {
                                        // Al pulsar sobre la Card, navegamos a la pantalla de detalle de cita.
                                        val index = biosList.indexOf(bio)
                                        navController.navigate("cita_screen/$index")
                                    },
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                border = BorderStroke(1.dp, Color(0xFFCAC4D0))
                            ) {
                                // Distribución en fila (Row) para colocar texto a la izquierda e imagen a la derecha.
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    // Columna con el nombre y la primera cita de la científica.
                                    Column(
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        // Nombre de la científica.
                                        Text(
                                            text = bio.nombre,
                                            fontWeight = FontWeight.Bold,
                                            overflow = TextOverflow.Ellipsis,
                                            maxLines = 1
                                        )

                                        // Obtenemos la primera línea de la cita (si existe) para mostrarla.
                                        val primeraCita = bio.cita
                                            .split("\n")
                                            .firstOrNull()
                                            ?.takeIf { it.isNotEmpty() }

                                        // Mostramos la cita (o un texto por defecto si no existe).
                                        Text(
                                            text = primeraCita ?: "Ninguna cita añadida.",
                                            modifier = Modifier.padding(top = 4.dp),
                                            overflow = TextOverflow.Ellipsis,
                                            maxLines = 2,
                                            fontSize = 12.sp,
                                            fontStyle = FontStyle.Italic,
                                            lineHeight = 16.sp
                                        )
                                    }

                                    // A la derecha, se muestra la imagen de la científica.
                                    val context = LocalContext.current
                                    val resourceId = context.resources.getIdentifier(
                                        bio.imageResName,
                                        "drawable",
                                        context.packageName
                                    )

                                    Image(
                                        painter = painterResource(
                                            // Si no se encuentra la imagen, se usa un recurso placeholder por defecto.
                                            id = if (resourceId != 0) resourceId else R.drawable.placeholder_image
                                        ),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(88.dp)    // Tamaño fijo de la imagen.
                                            .padding(start = 8.dp)
                                            .clip(CircleShape) // Forma circular.
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

// Vista previa en modo claro con altura extendida.
@Preview(showBackground = true, heightDp = 2000)
@Composable
fun ScrollCitasPreview() {
    AppStemTheme {
        ScrollCitas(navController = rememberNavController())
    }
}

// Vista previa en modo oscuro.
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ScrollCitasDarkPreview() {
    AppStemTheme {
        ScrollCitas(navController = rememberNavController())
    }
}
