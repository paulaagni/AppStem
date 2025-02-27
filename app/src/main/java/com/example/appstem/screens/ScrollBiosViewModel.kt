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
import kotlinx.coroutines.launch

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

    fun addCita(id: Int, nuevaCita: String) {
        viewModelScope.launch {
            allBiosFlow.collect { bios ->
                val updatedBio = bios.find { it.id == id }
                updatedBio?.let {
                    // Comprobar si la nueva cita ya está en las citas existentes
                    val citasExistentes = it.cita.split("\n")?.toSet() ?: setOf()

                    // Si la nueva cita no está en las citas existentes, la añadimos
                    if (!citasExistentes.contains(nuevaCita.trim())) {
                        val updatedCitas = if (it.cita.isEmpty()) nuevaCita else it.cita + "\n" + nuevaCita
                        val updatedBioWithCita = it.copy(cita = updatedCitas)
                        cientificasDao.updateCita(updatedBioWithCita)
                    }
                }
            }
        }
    }


    fun deleteCita(id: Int, citaAEliminar: String) {
        viewModelScope.launch {
            allBiosFlow.collect { bios ->
                val updatedBio = bios.find { it.id == id }
                updatedBio?.let {
                    // Filtramos las citas para eliminar la que coincide
                    val citasList = it.cita.split("\n").filter { cita -> cita != citaAEliminar }
                    val updatedCitas = citasList.joinToString("\n") // Unir las citas restantes
                    val updatedBioWithCita = it.copy(cita = updatedCitas)
                    // Actualizamos la biografía con las citas modificadas
                    cientificasDao.updateCita(updatedBioWithCita)
                }
            }
        }
    }


    fun updateCita(id: Int, citaOriginal: String, nuevaCita: String) {
        viewModelScope.launch {
            allBiosFlow.collect { bios ->
                val updatedBio = bios.find { it.id == id }
                updatedBio?.let {
                    // Dividir las citas y buscar la cita a actualizar
                    val citasList = it.cita.split("\n").map { cita ->
                        if (cita == citaOriginal) nuevaCita else cita // Reemplazar la cita original por la nueva
                    }

                    val updatedCitas = citasList.joinToString("\n") // Unir las citas actualizadas
                    val updatedBioWithCita = it.copy(cita = updatedCitas)
                    cientificasDao.updateCita(updatedBioWithCita) // Actualizar en la base de datos
                }
            }
        }
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
