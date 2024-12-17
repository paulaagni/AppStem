package com.example.appstem.model

import com.example.appstem.R

// Clase de datos para representar información biográfica
data class DataScroll(
    val name: String,       // Nombre de la persona
    val profession: String, // Profesión o área de especialidad
    val imagenId: Int       // ID del recurso de imagen asociado
)

// Lista de objetos que contiene información sobre mujeres destacadas en STEM
val info = listOf(
    DataScroll("Hypatia de Alejandría", "Matemática", R.drawable.hypatia),
    DataScroll("Hedy Lamarr", "Inventora", R.drawable.hedylamarr),
    DataScroll("Rachel Louise Carson", "Bióloga", R.drawable.rachelcarson),
    DataScroll("Mary Anning", "Paleontóloga", R.drawable.maryanning),
    DataScroll("Alice Ball", "Química", R.drawable.aliceball),
    DataScroll("Marie Curie", "Física", R.drawable.mariecurie),
    DataScroll("Ada Lovelace", "Matemática", R.drawable.adalovelace),
    DataScroll("Lise Meitner", "Física", R.drawable.lisemeitner),
    DataScroll("Edith Clarke", "Ingeniera", R.drawable.edithclarke),
    DataScroll("Maryam Mirzakhani", "Matemática", R.drawable.maryammirzakhani),
    DataScroll("Cecilia Payne-Gaposchkin", "Astrónoma", R.drawable.ceciliapayne),
    DataScroll("Emmy Noether", "Matemática", R.drawable.emmynoether),
    DataScroll("Mary Agnes Chase", "Botánica", R.drawable.maryagneschase),
    DataScroll("Gerty Cori", "Bioquímica", R.drawable.gertycori),
    DataScroll("Esther Lederberg", "Microbióloga", R.drawable.estherlederberg),
    DataScroll("Valentina Tereshkova", "Cosmonauta", R.drawable.valentinatereshkova),
    DataScroll("Annie J. Easley", "Informática", R.drawable.annieeasley),
    DataScroll("Vera Rubin", "Astrónoma", R.drawable.verarubin),
    DataScroll("Jane Cooke Wright", "Oncóloga", R.drawable.janecookewright),
    DataScroll("Jane Goodall", "Primatóloga", R.drawable.janegoodall),
    DataScroll("Alicia Asín","Ingeniera",R.drawable.alicia_asin),
    DataScroll("Ana Maiques","Física", R.drawable.ana_maiques),
    DataScroll("Andrea Barber","Ingeniera Biotecnóloga",R.drawable.andrea_barber),
    DataScroll("Aridna Farres","Ingeniera industrial", R.drawable.ariadna_farres),
    DataScroll("Ariadna Font Llitjó", "Ingeniera Industrial", R.drawable.ariadna_font),
    DataScroll("Elena García Armada", "Ingeniera de \ntelecomunicaciones", R.drawable.elena_garcia),
    DataScroll("Elisenda Bou", "Biotecnóloga", R.drawable.elisenda_bou),
)