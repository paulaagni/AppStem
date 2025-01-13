package com.example.appstem.model

import com.example.appstem.R

data class DataBios (
    val name: String,
    val profession: String,
    val description: String,
    val imageId: Int
)

val infoBios = listOf(
    DataBios(R.string.hypatia_de_alejandria.toString(), "Matemática", "", R.drawable.hypatia),
    DataBios("Hedy Lamarr", "Inventora", "", R.drawable.hedylamarr),
    DataBios("Rachel Louise Carson", "Bióloga", "", R.drawable.rachelcarson),
    DataBios("Mary Anning", "Paleontóloga", "", R.drawable.maryanning),
    DataBios("Alice Ball", "Química", "", R.drawable.aliceball),
    DataBios("Marie Curie", "Física", "", R.drawable.mariecurie),
    DataBios("Ada Lovelace", "Matemática", "", R.drawable.adalovelace),
    DataBios("Lise Meitner", "Física", "", R.drawable.lisemeitner),
    DataBios("Edith Clarke", "Ingeniera", "", R.drawable.edithclarke),
    DataBios("Maryam Mirzakhani", "Matemática", "", R.drawable.maryammirzakhani),
    DataBios("Cecilia Payne-Gaposchkin", "Astrónoma", "",  R.drawable.ceciliapayne),
    DataBios("Emmy Noether", "Matemática", "", R.drawable.emmynoether),
    DataBios("Mary Agnes Chase", "Botánica", "", R.drawable.maryagneschase),
    DataBios("Gerty Cori", "Bioquímica", "", R.drawable.gertycori),
    DataBios("Esther Lederberg", "Microbióloga", "", R.drawable.estherlederberg),
    DataBios("Valentina Tereshkova", "Cosmonauta", "", R.drawable.valentinatereshkova),
    DataBios("Annie J. Easley", "Informática", "", R.drawable.annieeasley),
    DataBios("Vera Rubin", "Astrónoma", "", R.drawable.verarubin),
    DataBios("Jane Cooke Wright", "Oncóloga", "", R.drawable.janecookewright),
    DataBios("Jane Goodall", "Primatóloga", "", R.drawable.janegoodall)
)