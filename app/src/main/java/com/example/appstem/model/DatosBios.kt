package com.example.appstem.model

import com.example.appstem.R

// Clase de datos para representar información biográfica
data class DatosBios(
    val name: String,       // Nombre de la persona
    val profession: String, // Profesión o área de especialidad
    val imagenId: Int       // ID del recurso de imagen asociado
)

// Lista de objetos que contiene información sobre mujeres destacadas en STEM
val info = listOf(
    DatosBios("Hypatia de Alejandría", "Matemática", R.drawable.hypatia),
    DatosBios("Hedy Lamarr", "Inventora", R.drawable.hedylamarr),
    DatosBios("Rachel Louise Carson", "Bióloga", R.drawable.rachelcarson),
    DatosBios("Mary Anning", "Paleontóloga", R.drawable.maryanning),
    DatosBios("Alice Ball", "Química", R.drawable.aliceball),
    DatosBios("Marie Curie", "Física", R.drawable.mariecurie),
    DatosBios("Ada Lovelace", "Matemática", R.drawable.adalovelace),
    DatosBios("Lise Meitner", "Física", R.drawable.lisemeitner),
    DatosBios("Edith Clarke", "Ingeniera", R.drawable.edithclarke),
    DatosBios("Maryam Mirzakhani", "Matemática", R.drawable.maryammirzakhani),
    DatosBios("Cecilia Payne-Gaposchkin", "Astrónoma", R.drawable.ceciliapayne),
    DatosBios("Emmy Noether", "Matemática", R.drawable.emmynoether),
    DatosBios("Mary Agnes Chase", "Botánica", R.drawable.maryagneschase),
    DatosBios("Gerty Cori", "Bioquímica", R.drawable.gertycori),
    DatosBios("Esther Lederberg", "Microbióloga", R.drawable.estherlederberg),
    DatosBios("Valentina Tereshkova", "Cosmonauta", R.drawable.valentinatereshkova),
    DatosBios("Annie J. Easley", "Informática", R.drawable.annieeasley),
    DatosBios("Vera Rubin", "Astrónoma", R.drawable.verarubin),
    DatosBios("Jane Cooke Wright", "Oncóloga", R.drawable.janecookewright),
    DatosBios("Jane Goodall", "Primatóloga", R.drawable.janegoodall)
)