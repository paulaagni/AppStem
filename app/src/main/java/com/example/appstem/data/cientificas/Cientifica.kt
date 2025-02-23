package com.example.appstem.data.cientificas


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "cientificas")
data class Cientifica (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val profesion: String,
    val descripcion: String,
    val cita : String
)