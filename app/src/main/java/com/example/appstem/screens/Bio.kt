package com.example.appstem.screens

// Importaciones necesarias para la creación de la pantalla y los componentes UI.
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appstem.R
import com.example.appstem.model.infoBios
import com.example.appstem.ui.theme.AppStemTheme

// Composable principal que representa la biografía de Hypatia.
@Composable
fun BioScreen(navController: NavController, bioIndex: Int) {
    val bio = infoBios[bioIndex]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Image(
                painter = painterResource(id = bio.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = stringResource(bio.name),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = stringResource(bio.profession),
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(bio.description),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}


// Vista previa de la pantalla en Android Studio.
@Preview(showBackground = true)
@Composable
fun PreviewBioScreen() {
    AppStemTheme {
        val navController = rememberNavController() // Crea un controlador de navegación para la vista previa.
        BioScreen(navController,1) // Llama a la función principal con el controlador.
    }
}
