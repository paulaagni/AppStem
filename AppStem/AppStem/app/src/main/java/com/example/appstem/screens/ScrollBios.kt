package com.example.appstem.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appstem.R
import com.example.appstem.navigation.AppScreens

data class DatosBios(
    val name: String,
    val profession: String,
    val imagenId: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollBios(navController: NavController) {
    val info = listOf(
        DatosBios("Hypatia de Alejandría", "Matemática", R.drawable.hypatia),
        DatosBios("Hedy Lamarr", "Inventora", R.drawable.hedylamarr),
        DatosBios("Rachel Louise Carson", "Bióloga", R.drawable.rachelcarson),
        DatosBios("Mary Anning", "Paleontóloga", R.drawable.maryanning),
        DatosBios("Alice Ball", "Química", R.drawable.aliceball),
        DatosBios("Marie Curie", "Física", R.drawable.mariecurie)
    )

    val busquedaBarra = remember { mutableStateOf("") }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                ),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ArrowBack",
                            modifier = Modifier
                                .size(24.dp)
                                .padding(end = 8.dp)
                                .clickable{navController.popBackStack()}
                        )
                        Text("Biografías")
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .background(Color.White)
            ){
                TextField(
                    value = busquedaBarra.value,
                    onValueChange = { busquedaBarra.value = it },
                    label = { Text("Buscar", color = Color.Black) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
                    },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        disabledTextColor = Color.Gray,
                        errorTextColor = Color.Red,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        cursorColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                val filtroBusqueda = info.filter {
                    it.name.contains(busquedaBarra.value, ignoreCase = true)
                }

                LazyColumn {
                    items(filtroBusqueda) { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable {
                                    if(item.name == "Hypatia de Alejandría")
                                        navController.navigate(route = AppScreens.Bio.route)
                                },
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            border = BorderStroke(1.dp, Color(0xFFCAC4D0))
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        text = item.name,
                                        style = MaterialTheme.typography.titleMedium,
                                        overflow = TextOverflow.Ellipsis,
                                        maxLines = 1
                                    )
                                    Text(
                                        text = item.profession,
                                        style = MaterialTheme.typography.titleSmall,
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                }

                                Image(
                                    painter = painterResource(id = item.imagenId),
                                    contentDescription = null,
                                    modifier =
                                    if (item.imagenId == R.drawable.maryanning || item.imagenId == R.drawable.hedylamarr || item.imagenId == R.drawable.rachelcarson){
                                        Modifier.size(70.dp)
                                    }else {
                                        Modifier.size(50.dp)
                                    }
                                        .padding(start = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview (showBackground = true)
@Composable
fun ScrollBiosPreview(){
    ScrollBios(navController = rememberNavController())
}