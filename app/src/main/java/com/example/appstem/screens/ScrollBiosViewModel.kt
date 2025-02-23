package com.example.appstem.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.appstem.BaseApplication
import com.example.appstem.data.cientificas.CientificasDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.SharingStarted

/**
 * ViewModel que gestiona los datos de las biografías y la lógica de filtrado según la búsqueda.
 *
 * Recibe el DAO para acceder a la base de datos Room.
 */
class ScrollBiosViewModel(private val cientificasDao: CientificasDao) : ViewModel() {

    // Flow que almacena el query de búsqueda.
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> get() = _searchQuery

    // Flow con todas las biografías obtenidas de la base de datos.
    private val allBiosFlow = cientificasDao.getAllBios()

    // Flow que combina el query de búsqueda y la lista completa para filtrar las biografías.
    val filteredBios = combine(_searchQuery, allBiosFlow) { query, bios ->
        if (query.isBlank()) {
            bios
        } else {
            bios.filter { bio ->
                // Se filtra por nombre o profesión ignorando mayúsculas/minúsculas.
                bio.nombre.contains(query, ignoreCase = true) ||
                        bio.profesion.contains(query, ignoreCase = true)
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Actualiza el query de búsqueda.
    fun onSearchQueryChanged(newQuery: String) {
        _searchQuery.value = newQuery
    }

    companion object {
        // Definición del Factory para crear instancias del ViewModel utilizando viewModelFactory.
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                // Se obtiene la instancia de la aplicación y, a partir de ella, el DAO.
                val application = (this[APPLICATION_KEY] as BaseApplication)
                // Se crea el ViewModel con el DAO obtenido de la base de datos.
                ScrollBiosViewModel(application.database.cientificasDao())
            }
        }
    }
}
