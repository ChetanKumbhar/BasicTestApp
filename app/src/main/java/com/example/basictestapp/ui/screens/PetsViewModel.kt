package com.example.basictestapp.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basictestapp.domain.usecases.pet.PetUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetsViewModel @Inject constructor(
    private val petUseCases: PetUseCases
) : ViewModel() {

    private val _state = mutableStateOf(PetListState())
    val state: State<PetListState> get() = _state

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            try {
                val items = petUseCases.getPets.invoke().toList().flatten()
                // Update the state with the new list of items
                _state.value = state.value.copy(items = items)
            } catch (e: Exception) {
                _state.value = e.message?.let { state.value.copy(error = it) }!!
            }
        }
    }

}