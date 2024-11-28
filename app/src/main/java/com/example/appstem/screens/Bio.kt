package com.example.appstem.screens

// Importaciones necesarias para la creación de la pantalla y los componentes UI.
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.appstem.ui.theme.AppStemTheme

// Composable principal que representa la biografía de Hypatia.
@Composable
fun BiografiaHypatia(navController: NavController) {
    // Contenedor principal que ocupa todo el tamaño disponible.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) // Margen exterior de la pantalla.
    ) {
        // Columna principal que contiene el contenido de la biografía.
        Column(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el tamaño disponible.
                .verticalScroll(rememberScrollState()), // Habilita el scroll vertical.
            horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido horizontalmente.
        ) {
            Spacer(modifier = Modifier.height(32.dp)) // Espaciador para separar elementos.

            // Imagen de Hypatia con un tamaño fijo.
            Image(
                painter = painterResource(id = R.drawable.hypatia),
                contentDescription = stringResource(R.string.descripcion_imagen), // Descripción para accesibilidad.
                contentScale = ContentScale.Crop, // Escala la imagen para ajustarse al tamaño.
                modifier = Modifier
                    .size(150.dp) // Tamaño de la imagen.
            )

            Spacer(modifier = Modifier.height(16.dp)) // Espaciador entre la imagen y el texto.

            // Columna que contiene la información textual de Hypatia.
            Column(horizontalAlignment = Alignment.Start) {
                // Nombre de Hypatia en negrita y con un tamaño mayor.
                Text(
                    text = stringResource(R.string.nombre_hypatia),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                // Ocupación de Hypatia.
                Text(
                    text = stringResource(R.string.ocupacion_hypatia),
                    fontSize = 16.sp
                )

                // Subcolumna centrada que contiene un título, subtítulo y descripción.
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    // Título principal en negrita y centrado.
                    Text(
                        text = stringResource(R.string.titulo_principal),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )

                    // Subtítulo centrado.
                    Text(
                        text = stringResource(R.string.subtitulo),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp)) // Espaciador entre subtítulo y descripción.

                    // Descripción de Hypatia, justificada y con margen horizontal.
                    Text(
                        text = stringResource(R.string.descripcion_hypatia),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp)) // Espaciador antes de los botones.

            // Fila que contiene los botones al final de la pantalla.
            Row(
                modifier = Modifier
                    .fillMaxWidth() // Ocupa todo el ancho disponible.
                    .padding(top = 16.dp), // Margen superior para separar los botones.
                horizontalArrangement = Arrangement.End // Alinea los botones al final de la fila.
            ) {
                // Botón "Favoritas" con esquinas redondeadas.
                Button(
                    onClick = { /* Acción para Favoritas */ },
                    shape = RoundedCornerShape(20.dp) // Esquinas redondeadas.
                ) {
                    Text(
                        text = stringResource(R.string.boton_favoritas) // Texto del botón.
                    )
                }

                Spacer(modifier = Modifier.width(8.dp)) // Espaciador entre los botones.

                // Botón "Volver" que regresa a la pantalla anterior.
                Button(
                    onClick = { navController.popBackStack() }, // Acción para regresar.
                    shape = RoundedCornerShape(20.dp) // Esquinas redondeadas.
                ) {
                    Text(
                        text = stringResource(R.string.boton_volver), // Texto del botón.
                    )
                }
            }
        }
    }
}

// Vista previa de la pantalla en Android Studio.
@Preview(showBackground = true)
@Composable
fun PreviewBiografiaHypatia() {
    AppStemTheme {
        val navController = rememberNavController() // Crea un controlador de navegación para la vista previa.
        BiografiaHypatia(navController) // Llama a la función principal con el controlador.
    }
}
