package com.example.appstem.data.cientificas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Anotación @Database que indica que esta clase define la base de datos Room.
// 'entities' señala la(s) entidad(es) que forman parte de la base de datos.
// 'version' determina la versión del esquema, útil para migraciones.
@Database(entities = [Cientifica::class], version = 1)
abstract class CientificasDatabase : RoomDatabase() {

    // Función abstracta que devuelve la interfaz DAO con las consultas a la entidad "Cientifica".
    abstract fun cientificasDao(): CientificasDao

    companion object {
        // La variable INSTANCE se marca con @Volatile para garantizar la visibilidad inmediata
        // de los cambios a otros hilos.
        @Volatile
        private var INSTANCE: CientificasDatabase? = null

        // Método para obtener una instancia única de la base de datos.
        // Si no existe, se crea con 'synchronized' para evitar que varios hilos la generen a la vez.
        fun getDatabase(context: Context): CientificasDatabase {
            return INSTANCE
                ?: synchronized(this) {
                    // Crea la base de datos usando Room.databaseBuilder,
                    // indicando el contexto, la clase de base de datos y el nombre del archivo.
                    Room.databaseBuilder(
                        context,
                        CientificasDatabase::class.java,
                        "cientificas_database"
                    )
                        // Carga la base de datos pre-poblada desde un archivo en assets.
                        .createFromAsset("database/cientificas.db")
                        // Si cambia la versión de la base de datos y no hay migraciones definidas,
                        // se destruye y recrea en lugar de fallar.
                        .fallbackToDestructiveMigration()
                        // Construimos la instancia de la base y la asignamos a INSTANCE.
                        .build()
                        .also {
                            INSTANCE = it
                        }
                }
        }
    }
}
