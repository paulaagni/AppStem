package com.example.appstem.screens

import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appstem.R
import com.example.appstem.ui.theme.AppStemTheme

@Composable
fun CitaScreen(
    navController: NavController,
    bioIndex: Int,
    viewModel: ScrollBiosViewModel = viewModel(factory = ScrollBiosViewModel.factory)
) {
    // Obtenemos la lista filtrada desde el ViewModel
    val biosList by viewModel.filteredBios.collectAsState()
    val bio = biosList.getOrNull(bioIndex) ?: return

    // -- CAMBIO 1: Limpiamos y filtramos las citas al inicializar la variable --
    var citasList by remember {
        mutableStateOf(
            bio.cita
                .split("\n")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
        )
    }

    // Estados para añadir / editar
    var nuevaCita by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    var showEditDialog by remember { mutableStateOf(false) }
    var citaEditable by remember { mutableStateOf("") }
    var citaOriginal by remember { mutableStateOf("") } // Para saber cuál se edita

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .padding(bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Botón "Volver"
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.Start)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Volver",
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar imagen
            val context = LocalContext.current
            val resourceId = context.resources.getIdentifier(
                bio.imageResName,
                "drawable",
                context.packageName
            )
            Image(
                painter = painterResource(
                    id = if (resourceId != 0) resourceId else R.drawable.placeholder_image
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(
                    text = bio.nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = bio.profesion,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(16.dp))

                // -- CAMBIO 2: Iteramos sobre las citas limpias --
                val citasNoVacias = citasList.filter { it.isNotBlank() }

                if (citasNoVacias.isEmpty()) {
                    Text("Ninguna cita añadida.")
                } else {
                    citasNoVacias.forEach { cita ->
                        Card(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth(),
                            elevation = CardDefaults.elevatedCardElevation(4.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = cita,
                                    fontStyle = FontStyle.Italic,
                                    fontSize = 14.sp
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    TextButton(
                                        onClick = {
                                            citaOriginal = cita
                                            citaEditable = cita
                                            showEditDialog = true
                                        }
                                    ) {
                                        Text("Modificar")
                                    }

                                    TextButton(
                                        onClick = {
                                            // Eliminamos en la BD
                                            viewModel.deleteCita(bio.id, cita)
                                            // Eliminamos en la UI
                                            citasList = citasList.filterNot { it == cita }
                                        }
                                    ) {
                                        Text("Eliminar")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // FAB para añadir nueva cita
        FloatingActionButton(
            onClick = { showDialog = true },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 80.dp)
                .navigationBarsPadding()
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Añadir cita"
            )
        }

        // Diálogo para añadir nueva cita
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text(text = "Añadir nueva cita") },
                text = {
                    TextField(
                        value = nuevaCita,
                        onValueChange = { nuevaCita = it },
                        label = { Text("Introduce la cita") },
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            // -- CAMBIO 3: Evitamos añadir cita vacía --
                            val citaLimpia = nuevaCita.trim()
                            if (citaLimpia.isNotEmpty()) {
                                viewModel.addCita(bio.id, citaLimpia)
                                citasList = citasList + citaLimpia
                            }
                            // Cerramos el diálogo y reseteamos
                            nuevaCita = ""
                            showDialog = false
                        }
                    ) {
                        Text("Añadir")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }

        // Diálogo para modificar una cita
        if (showEditDialog) {
            AlertDialog(
                onDismissRequest = { showEditDialog = false },
                title = { Text(text = "Editar cita") },
                text = {
                    TextField(
                        value = citaEditable,
                        onValueChange = { citaEditable = it },
                        label = { Text("Modifica la cita") },
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            val citaLimpia = citaEditable.trim()
                            if (citaLimpia.isNotEmpty()) {
                                // Actualizamos en la BD
                                viewModel.updateCita(bio.id, citaOriginal, citaLimpia)
                                // Y actualizamos en la UI
                                citasList = citasList.map { if (it == citaOriginal) citaLimpia else it }
                            }
                            showEditDialog = false
                        }
                    ) {
                        Text("Guardar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showEditDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCitaScreen() {
    AppStemTheme {
        val navController = rememberNavController()
        CitaScreen(navController, 1)
    }
}
