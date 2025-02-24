package com.example.appstem.data.cientificas


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cientificas")
data class Cientifica(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "name")
    val nombre: String,           // en la BD se llama "name"

    @ColumnInfo(name = "profession")
    val profesion: String,        // en la BD se llama "profession"

    @ColumnInfo(name = "description")
    val descripcion: String,      // en la BD se llama "description"

    @ColumnInfo(name = "citas")
    val cita: String              // en la BD se llama "citas"
)
