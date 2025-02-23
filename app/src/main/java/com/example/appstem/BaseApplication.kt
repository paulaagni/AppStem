package com.example.appstem

import android.app.Application
import com.example.appstem.data.cientificas.CientificasDatabase

class BaseApplication : Application() {
    // Propiedad 'database' que se inicializa de forma perezosa (lazy).
    // Se obtiene la instancia singleton de la base de datos utilizando el contexto de la aplicación.
    val database: CientificasDatabase by lazy { CientificasDatabase.getDatabase(this) }
}
