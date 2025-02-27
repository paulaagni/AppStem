package com.example.appstem.data.cientificas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Anotación que indica que esta clase representa una tabla en la base de datos Room
@Entity(tableName = "cientificas")
data class Cientifica(
    // Este campo corresponde a la clave primaria (PrimaryKey) de la tabla
    @PrimaryKey
    val id: Int,

    // Columna 'name' en la tabla que mapea con la propiedad 'nombre' de la clase
    @ColumnInfo(name = "name")
    val nombre: String,

    // Columna 'profession' en la tabla que mapea con la propiedad 'profesion'
    @ColumnInfo(name = "profession")
    val profesion: String,

    // Columna 'description' para la descripción de la científica
    @ColumnInfo(name = "description")
    val descripcion: String,

    // Columna 'citas' que almacena una cita o frase característica
    @ColumnInfo(name = "citas")
    val cita: String,

    // NUEVO campo que contiene la referencia (nombre) del recurso de la imagen en drawable
    @ColumnInfo(name = "imageResName")
    val imageResName: String
)
