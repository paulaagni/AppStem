package com.example.appstem.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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

    // UI del Splash Screen
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Cargando...", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(8.dp),
                color = Color.Blue,
            )
        }
    }
}
