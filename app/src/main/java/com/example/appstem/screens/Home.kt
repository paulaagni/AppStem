package com.example.appstem.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appstem.R
import com.example.appstem.ui.theme.AppStemTheme
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController) {

    var activeIcon by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp), // Espaciado uniforme
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Espacio para el ícono de la app
                        Image(
                            painter = painterResource(R.drawable.logorecortado), // Reemplaza con tu recurso de ícono
                            contentDescription = "Icono de la app",
                            modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(8.dp)) // Bordes redondeados
                                .padding(8.dp) // Espacio interno
                        )
                        Spacer(modifier = Modifier.width(16.dp)) // Separación entre ícono y texto

                        // Títulos de la barra superior
                        Column {
                            Text(
                                text = "Pioneras",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    color = MaterialTheme.colorScheme.primary
                                )
                            )
                            Text(
                                text = "Mujeres que cambiaron la ciencia",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            )
                        }
                    }
                },
                modifier = Modifier.shadow(4.dp) // Sombra para destacar el TopAppBar
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.padding(bottom = 8.dp) // Espacio abajo
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp), // Espacio a los lados
                    horizontalArrangement = Arrangement.SpaceBetween // Espacio entre elementos
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier  .clickable(onClick = {
                            activeIcon = "biografias"
                        })
                            .background(
                                if (activeIcon == "biografias") Color(0xFFE8DEF8) else Color.Transparent
                            )
                            .size(width = 80.dp, height = 50.dp) // Tamaño fijo
                    ) {
                        Icon(Icons.Filled.AccountCircle, contentDescription = "Biografías")
                        Text(
                            text = "Biografías",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 4.dp) // Espacio entre el ícono y el texto
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier .clickable(onClick = {
                            activeIcon = "citas"
                        })
                            .background(
                                if (activeIcon == "citas") Color(0xFFE8DEF8) else Color.Transparent
                            )
                            .size(width = 80.dp, height = 50.dp) // Tamaño fijo
                    ) {
                        Icon(Icons.Filled.Create, contentDescription = "Citas")
                        Text(
                            text = "Citas",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 4.dp) // Espacio entre el ícono y el texto
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier .clickable(onClick = {
                            activeIcon = "favoritas"
                        })
                            .background(
                                if (activeIcon == "favoritas") Color(0xFFE8DEF8) else Color.Transparent
                            )
                            .size(width = 80.dp, height = 50.dp) // Tamaño fijo
                    ) {
                        Icon(Icons.Filled.FavoriteBorder, contentDescription = "Favoritas")
                        Text(
                            text = "Favoritas",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 8.dp) // Espacio entre el ícono y el texto
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        HomeContent(navController,innerPadding)
    }
}

@Composable
fun HomeContent(navController: NavController, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageModifier = Modifier
            .fillMaxWidth(0.80f) // Ajusta el ancho al 75% de la pantalla
            .height(200.dp) // Define una altura fija para todas las imágenes
            .padding(vertical = 6.dp) // Espaciado uniforme entre imágenes
            .border(
                width = 1.dp,
                color = Color.Gray.copy(alpha = 0.8f),
                shape = RoundedCornerShape(10.dp)
            )
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                // Acción de navegación al hacer clic
            }

        // Imagen 1
        Box(modifier = imageModifier) {
            Image(
                painter = painterResource(R.drawable.homeimagena),
                contentDescription = "Imagen Home A",
                contentScale = ContentScale.Crop, // Recorta para llenar el espacio definido
                modifier = Modifier.fillMaxSize()
            )
        }

        // Imagen 2
        Box(modifier = imageModifier) {
            Image(
                painter = painterResource(R.drawable.homeimagenc),
                contentDescription = "Imagen Home C",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Imagen 3
        Box(modifier = imageModifier) {
            Image(
                painter = painterResource(R.drawable.homeimagenb),
                contentDescription = "Imagen Home B",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HomePreview() {
    AppStemTheme {
        Home(navController = rememberNavController())
    }
}

