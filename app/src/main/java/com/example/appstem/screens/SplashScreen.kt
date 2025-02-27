package com.example.appstem.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.appstem.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    // Estado para controlar el progreso (valor entre 0 y 1)
    var progress by remember { mutableStateOf(0f) }

    // Simula la carga incrementando el progreso de forma gradual
    LaunchedEffect(key1 = true) {
        while (progress < 1f) {
            delay(50) // Ajusta el delay para modificar la velocidad de carga
            progress += 0.01f
        }
        // Una vez completada la carga, se llama a la acción de finalizar el splash
        onSplashFinished()
    }

    // Fondo con gradiente
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF1E3A8A), Color(0xFF3B82F6)) // Azul degradado
    )

    // UI del Splash Screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush), // Aplica el gradiente al fondo
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Imagen del logo
            Image(
                painter = painterResource(id = R.drawable.logostem),
                contentDescription = "Logo de la App",
                modifier = Modifier
                    .size(120.dp) // Tamaño del logo
                    .padding(bottom = 24.dp)
            )

            // Texto de carga
            Text(
                text = "Cargando...",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Barra de progreso
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(8.dp),
                color = Color.White,
            )
        }
    }
}
