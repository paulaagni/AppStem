package com.example.appstem.model

import com.example.appstem.R

data class DataBios (
    val name: Int,
    val profession: Int,
    val description: Int,
    val imageId: Int
)

val infoBios = listOf(
    DataBios(R.string.hypatia_de_alejandria, R.string.matematica, R.string.bio_hypatia, R.drawable.hypatia),
    DataBios(R.string.hedy_lamarr, R.string.inventora, R.string.bio_hedy_lamarr, R.drawable.hedylamarr),
    DataBios(R.string.rachel_louise_carson, R.string.biologa, R.string.bio_rachel_carson, R.drawable.rachelcarson),
    DataBios(R.string.mary_anning, R.string.paleontologa, R.string.bio_mary_anning, R.drawable.maryanning),
    DataBios(R.string.alice_ball, R.string.quimica, R.string.bio_alice_ball, R.drawable.aliceball),
    DataBios(R.string.marie_curie, R.string.fisica, R.string.bio_marie_curie, R.drawable.mariecurie),
    DataBios(R.string.ada_lovelace, R.string.matematica, R.string.bio_ada_lovelace, R.drawable.adalovelace),
    DataBios(R.string.lise_meitner, R.string.fisica, R.string.bio_lise_meitner, R.drawable.lisemeitner),
    DataBios(R.string.edith_clarke, R.string.ingeniera, R.string.bio_edith_clarke, R.drawable.edithclarke),
    DataBios(R.string.maryam_mirzakhani, R.string.matematica, R.string.bio_maryam_mirzakhani, R.drawable.maryammirzakhani),
    DataBios(R.string.cecilia_payne, R.string.astronoma, R.string.bio_cecilia_payne, R.drawable.ceciliapayne),
    DataBios(R.string.emmy_noether, R.string.matematica, R.string.bio_emmy_noether, R.drawable.emmynoether),
    DataBios(R.string.mary_agnes_chase, R.string.botanica, R.string.bio_mary_agnes_chase, R.drawable.maryagneschase),
    DataBios(R.string.gerty_cori, R.string.bioquimica, R.string.bio_gerty_cori, R.drawable.gertycori),
    DataBios(R.string.esther_lederberg, R.string.microbiologa, R.string.bio_esther_lederberg, R.drawable.estherlederberg),
    DataBios(R.string.valentina_tereshkova, R.string.cosmonauta, R.string.bio_valentina_tereshkova, R.drawable.valentinatereshkova),
    DataBios(R.string.annie_easley, R.string.informatica, R.string.bio_annie_easley, R.drawable.annieeasley),
    DataBios(R.string.vera_rubin, R.string.astronoma, R.string.bio_vera_rubin, R.drawable.verarubin),
    DataBios(R.string.jane_cooke_wright, R.string.oncologa, R.string.bio_jane_cooke_wright, R.drawable.janecookewright),
    DataBios(R.string.jane_goodall, R.string.primatologa, R.string.bio_jane_goodall, R.drawable.janegoodall),
    DataBios(R.string.alicia_asin, R.string.ingeniera,R.string.bio_alicia_asin, R.drawable.alicia_asin),
    DataBios(R.string.ana_maiques, R.string.fisica, R.string.bio_ana_maiques, R.drawable.ana_maiques),
    DataBios(R.string.andrea_barber, R.string.ingeniera_biotecnologa, R.string.bio_andrea_barber, R.drawable.andrea_barber),
    DataBios(R.string.ariadna_farres, R.string.ingeniera_industrial, R.string.bio_ariadna_farres, R.drawable.ariadna_farres),
    DataBios(R.string.ariadna_font_llitjo, R.string.ingeniera_industrial, R.string.bio_ariadna_font,R.drawable.ariadna_font),
    DataBios(R.string.elena_garcia_armada, R.string.ingeniera_de_telecomunicaciones, R.string.bio_elena_garcia, R.drawable.elena_garcia),
    DataBios(R.string.elisenda_bou, R.string.biotecnologa, R.string.bio_elisenda_bou,R.drawable.elisenda_bou),
)