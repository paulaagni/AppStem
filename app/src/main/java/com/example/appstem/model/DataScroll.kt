package com.example.appstem.model

import androidx.annotation.StringRes
import com.example.appstem.R

// Clase de datos para representar información biográfica
data class DataScroll(
    @StringRes val name: Int,       // Nombre de la persona
    @StringRes val profession: Int, // Profesión o área de especialidad
    val imagenId: Int       // ID del recurso de imagen asociado
)

// Lista de objetos que contiene información sobre mujeres destacadas en STEM
val info = listOf(
    DataScroll(R.string.hypatia_de_alejandria, R.string.matematica, R.drawable.hypatia),
    DataScroll(R.string.hedy_lamarr, R.string.inventora, R.drawable.hedylamarr),
    DataScroll(R.string.rachel_louise_carson, R.string.biologa, R.drawable.rachelcarson),
    DataScroll(R.string.mary_anning, R.string.paleontologa, R.drawable.maryanning),
    DataScroll(R.string.alice_ball, R.string.quimica, R.drawable.aliceball),
    DataScroll(R.string.marie_curie, R.string.fisica, R.drawable.mariecurie),
    DataScroll(R.string.ada_lovelace, R.string.matematica, R.drawable.adalovelace),
    DataScroll(R.string.lise_meitner, R.string.fisica, R.drawable.lisemeitner),
    DataScroll(R.string.edith_clarke, R.string.ingeniera, R.drawable.edithclarke),
    DataScroll(R.string.maryam_mirzakhani, R.string.matematica, R.drawable.maryammirzakhani),
    DataScroll(R.string.cecilia_payne_gaposchkin, R.string.astronoma, R.drawable.ceciliapayne),
    DataScroll(R.string.emmy_noether, R.string.matematica, R.drawable.emmynoether),
    DataScroll(R.string.mary_agnes_chase, R.string.botanica, R.drawable.maryagneschase),
    DataScroll(R.string.gerty_cori, R.string.bioquimica, R.drawable.gertycori),
    DataScroll(R.string.esther_lederberg, R.string.microbiologa, R.drawable.estherlederberg),
    DataScroll(R.string.valentina_tereshkova, R.string.cosmonauta, R.drawable.valentinatereshkova),
    DataScroll(R.string.annie_j_easley, R.string.informatica, R.drawable.annieeasley),
    DataScroll(R.string.vera_rubin, R.string.astronoma, R.drawable.verarubin),
    DataScroll(R.string.jane_cooke_wright, R.string.oncologa, R.drawable.janecookewright),
    DataScroll(R.string.jane_goodall, R.string.primatologa, R.drawable.janegoodall),
    DataScroll(R.string.alicia_asin, R.string.ingeniera, R.drawable.alicia_asin),
    DataScroll(R.string.ana_maiques, R.string.fisica, R.drawable.ana_maiques),
    DataScroll(R.string.andrea_barber, R.string.ingeniera_biotecnologa, R.drawable.andrea_barber),
    DataScroll(R.string.ariadna_farres, R.string.ingeniera_industrial, R.drawable.ariadna_farres),
    DataScroll(R.string.ariadna_font_llitjo, R.string.ingeniera_industrial, R.drawable.ariadna_font),
    DataScroll(R.string.elena_garcia_armada, R.string.ingeniera_de_telecomunicaciones, R.drawable.elena_garcia),
    DataScroll(R.string.elisenda_bou, R.string.biotecnologa, R.drawable.elisenda_bou),
    )