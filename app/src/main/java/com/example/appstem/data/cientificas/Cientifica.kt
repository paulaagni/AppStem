package com.example.appstem.data.cientificas


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cientificas")
data class Cientifica(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "name")
    val nombre: String,

    @ColumnInfo(name = "profession")
    val profesion: String,

    @ColumnInfo(name = "description")
    val descripcion: String,

    @ColumnInfo(name = "citas")
    val cita: String,

    // NUEVO campo para la referencia de la imagen
    @ColumnInfo(name = "imageResName")
    val imageResName: String
)
