package com.example.appstem.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appstem.R
import com.example.appstem.navigation.AppScreens
import com.example.appstem.ui.theme.AppStemTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController) {

    var activeIcon by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp)

                    ) {
                        Text(
                            stringResource(R.string.pioneras),
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            stringResource(R.string.mujeres_que_cambiaron_la_ciencia),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
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
                        modifier = Modifier
                            .clickable(onClick = {
                                activeIcon = "biografias"
                            })
                            .background(
                                if (activeIcon == "biografias") Color(0xFFE8DEF8) else Color.Transparent
                            )
                            .size(width = 80.dp, height = 50.dp) // Tamaño fijo
                    ) {
                        Icon(Icons.Filled.AccountCircle, contentDescription = "Biografías")
                        Text(
                            text = stringResource(R.string.biograf_as),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 4.dp) // Espacio entre el ícono y el texto
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clickable(onClick = {
                                activeIcon = "citas"
                            })
                            .background(
                                if (activeIcon == "citas") Color(0xFFE8DEF8) else Color.Transparent
                            )
                            .size(width = 80.dp, height = 50.dp) // Tamaño fijo
                    ) {
                        Icon(Icons.Filled.Create, contentDescription = "Citas")
                        Text(
                            text = stringResource(R.string.citas),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 4.dp) // Espacio entre el ícono y el texto
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clickable(onClick = {
                                activeIcon = "favoritas"
                            })
                            .background(
                                if (activeIcon == "favoritas") Color(0xFFE8DEF8) else Color.Transparent
                            )
                            .size(width = 80.dp, height = 50.dp) // Tamaño fijo
                    ) {
                        Icon(Icons.Filled.FavoriteBorder, contentDescription = "Favoritas")
                        Text(
                            text = stringResource(R.string.favoritas),
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
        verticalArrangement = Arrangement.Center, // Centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
    ) {
        ElevatedButton(
            onClick = {
                navController.navigate(route = AppScreens.ScrollBios.route)
            },
            modifier = Modifier.fillMaxWidth(0.5f) // El botón será más pequeño y no ocupará todo el ancho
        ) {
            Text("Comenzar")
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

