package com.example.appstem.data.cientificas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


// Definimos una interfaz DAO para acceder a la tabla "cientificas" en la base de datos.
// La función getAll() obtiene todas las científicas de la base de datos y devuelve
// un Flow de una lista de objetos Cientificas.
    @Dao
    interface CientificasDao {

        @Query("SELECT * FROM cientificas")
        fun getAllBios(): Flow<List<Cientifica>>

    @Update
    suspend fun updateCita(cientifica: Cientifica)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cientifica: Cientifica)

    @Delete
    suspend fun delete(cientifica: Cientifica)

    }