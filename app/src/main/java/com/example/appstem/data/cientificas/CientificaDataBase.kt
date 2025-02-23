package com.example.appstem.data.cientificas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Definimos una clase abstracta que extiende RoomDatabase para crear la base de datos "CientificasDatabase".
// La base de datos contiene la entidad "Cientifica"

// La función cientificasDao() devuelve el DAO con las consultas para la entidad "Cientifica".

@Database(entities = [Cientifica::class], version = 1)
abstract class CientificasDatabase : RoomDatabase() {
    abstract fun cientificasDao(): CientificasDao

    companion object {
        @Volatile
        private var INSTANCE: CientificasDatabase? = null

        fun getDatabase(context: Context): CientificasDatabase {
            return INSTANCE
                ?: synchronized(this) {
                    Room.databaseBuilder(
                        context,
                        CientificasDatabase::class.java,
                        "cientificas_database"
                    )
                        .createFromAsset("database/cientificas.db")
                        .fallbackToDestructiveMigration()
                        .build()
                        .also {
                            INSTANCE = it
                        }
                }
        }
    }
}