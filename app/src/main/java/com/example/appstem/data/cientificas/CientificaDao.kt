package com.example.appstem.data.cientificas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Anotación @Dao para indicar que esta interfaz define operaciones de acceso a datos (Data Access Object)
@Dao
interface CientificasDao {

    // Consulta que devuelve todas las filas de la tabla "cientificas" como un Flow de List<Cientifica>.
    // Flow permite obtener actualizaciones automáticas cuando cambian los datos en la base.
    @Query("SELECT * FROM cientificas")
    fun getAllBios(): Flow<List<Cientifica>>

    // Actualiza la información (en concreto la 'cita' u otro campo modificado) de un objeto Cientifica existente.
    @Update
    suspend fun updateCita(cientifica: Cientifica)

    // Inserta un objeto Cientifica en la base de datos. Si existe un conflicto (mismo id), reemplaza el registro.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cientifica: Cientifica)

    // Elimina un objeto Cientifica específico de la base de datos.
    @Delete
    suspend fun delete(cientifica: Cientifica)
}
