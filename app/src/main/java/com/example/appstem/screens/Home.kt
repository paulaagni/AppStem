package com.example.appstem.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appstem.navigation.AppScreens
import com.example.appstem.ui.theme.AppStemTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController) {
      Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Text(
                            "Pioneras",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            "Mujeres que cambiaron la ciencia",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            )
        }

    ) { innerPadding ->
        HomeContent(navController, innerPadding)
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
        ElevatedButton(
            onClick = {
                navController.navigate(route = AppScreens.ScrollBios.route)
            },
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text("Comenzar")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HomePreview() {
    AppStemTheme {
        Home(
            navController = rememberNavController()
        )
    }
}


