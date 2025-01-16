package com.example.appstem.screens

// Importaciones necesarias para la creación de la pantalla y los componentes UI.
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
    val bio = infoBios[bioIndex] // Obtiene la biografía correspondiente según el índice proporcionado.

    Box(
        modifier = Modifier
            .fillMaxSize() // El Box ocupa todo el tamaño disponible de la pantalla
            .padding(16.dp) // Aplica un relleno de 16dp alrededor del Box
    ) {
        // Column para organizar los elementos en disposición vertical
        Column(
            modifier = Modifier
                .fillMaxSize() // La columna ocupa todo el tamaño disponible
                .verticalScroll(rememberScrollState()) // Permite el desplazamiento vertical si el contenido excede la pantalla
                .padding(start = 16.dp, end = 16.dp, bottom = 90.dp), // Relleno dentro de la columna
            horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
        ) {
            Spacer(modifier = Modifier.height(32.dp)) // Espacio de 32dp entre la parte superior y la imagen

            // Imagen de la persona (Hypatia), recortada en forma circular
            Image(
                painter = painterResource(id = bio.imageId), // Obtiene la imagen desde los recursos
                contentDescription = null, // No es necesario un contenido descriptivo aquí
                contentScale = ContentScale.Crop, // Recorta la imagen para ajustarla
                modifier = Modifier
                    .size(150.dp) // La imagen tendrá un tamaño de 150dp
                    .clip(CircleShape) // Aplica una forma circular a la imagen
            )

            Spacer(modifier = Modifier.height(16.dp)) // Espacio de 16dp debajo de la imagen

            // Columna para organizar el texto de la biografía
            Column(horizontalAlignment = Alignment.Start) {
                // Nombre de la persona en negrita y tamaño de fuente 20sp
                Text(
                    text = stringResource(bio.name),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                // Profesión de la persona con tamaño de fuente 16sp
                Text(
                    text = stringResource(bio.profession),
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(16.dp)) // Espacio de 16dp entre el nombre y la descripción

                // Descripción de la biografía, con texto justificado y tamaño de fuente 14sp
                Text(
                    text = stringResource(bio.description),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify
                )

                Spacer(modifier = Modifier.height(40.dp)) // Espacio de 40dp antes de los botones

                // Usamos un Row para poner los botones en paralelo (uno al lado del otro)
                Row(
                    modifier = Modifier
                        .fillMaxWidth(), // El Row ocupa todo el ancho disponible
                    horizontalArrangement = Arrangement.spacedBy(8.dp), // Espaciado de 8dp entre los botones
                    verticalAlignment = Alignment.CenterVertically // Alinea los botones verticalmente en el centro
                ) {
                    // Primer botón (Favoritas)
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(20.dp), // Forma redondeada con 20dp de radio
                        modifier = Modifier.weight(1f) // Hace que el botón ocupe la mitad del espacio disponible
                    ) {
                        Text(
                            text = stringResource(R.string.boton_favoritas) // Texto del botón, obtenido de los recursos
                        )
                    }

                    // Segundo botón (Volver)
                    Button(
                        onClick = { navController.popBackStack() }, // Acción para regresar a la pantalla anterior
                        shape = RoundedCornerShape(20.dp), // Forma redondeada con 20dp de radio
                        modifier = Modifier.weight(1f) // Hace que el botón ocupe la mitad del espacio disponible
                    ) {
                        Text(
                            text = stringResource(R.string.boton_volver) // Texto del botón, obtenido de los recursos
                        )
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
