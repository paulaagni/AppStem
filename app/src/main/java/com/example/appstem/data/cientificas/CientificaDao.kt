package com.example.appstem.data.cientificas

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


    // Definimos una interfaz DAO para acceder a la tabla "cientificas" en la base de datos.
// La función getAll() obtiene todas las científicas de la base de datos y devuelve
// un Flow de una lista de objetos Cientificas.
    @Dao
    interface CientificasDao {

        @Query("SELECT * FROM cientificas")
        fun getAllBios(): Flow<List<Cientifica>>

    }