package com.example.appstem.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appstem.model.info
import com.example.appstem.navigation.AppScreens
import com.example.appstem.ui.theme.AppStemTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollBios(navController: NavController) {

    val busquedaBarra = remember { mutableStateOf("") }

    AppStemTheme{
        Scaffold(
            topBar = {

                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                ),
                    title = {
                        Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Biografías")
                        }
                    }
                )
                     },

            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(start = 16.dp, end= 16.dp, bottom = 90.dp)
                ) {
                TextField(
                    value = busquedaBarra.value,
                    onValueChange = { busquedaBarra.value = it },
                    label = { Text("Buscar") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
                    },
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
                                    if (item.name == "Hypatia de Alejandría")
                                        navController.navigate(route = AppScreens.Bio.route)
                                },

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
                                        fontWeight = FontWeight.Bold,
                                        overflow = TextOverflow.Ellipsis,
                                        maxLines = 1
                                    )
                                    Text(
                                        text = item.profession,
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                }

                                Image(
                                    painter = painterResource(id = item.imagenId),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(88.dp)
                                        .padding(start = 8.dp)
                                        .clip(CircleShape)
                                )
                            }
                        }
                    }
                }
                }
            }
        )
    }
}

@Preview (showBackground = true, heightDp = 2000)
@Composable
fun ScrollBiosPreview(){
    AppStemTheme {
        ScrollBios(navController = rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ScrollBiosDarkPreview() {
    AppStemTheme {
        ScrollBios(navController = rememberNavController())
    }
}