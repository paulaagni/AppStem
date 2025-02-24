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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appstem.R
import com.example.appstem.ui.theme.AppStemTheme

@Composable
fun BioScreen(
    navController: NavController,
    bioIndex: Int,
    viewModel: ScrollBiosViewModel = viewModel(factory = ScrollBiosViewModel.factory)
) {
    // Recogemos la lista filtrada y obtenemos la biografía según el índice.
    val biosList by viewModel.filteredBios.collectAsState()
    val bio = biosList.getOrNull(bioIndex) ?: return

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
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
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = bio.profesion,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = bio.descripcion,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(40.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { /* Acción para Favoritas */ },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Favoritas")
                    }
                    Button(
                        onClick = { navController.popBackStack() },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Volver")
                    }
                }
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
        BioScreen(navController, 1) // Llama a la función principal con el controlador.
    }
}
