package com.example.basictestapp.ui.screens

import com.example.basictestapp.data.module.Pet

data class PetListState(
    val isLoading: Boolean = false,
    val items: List<Pet> = listOf(),
    val error: String = ""
    )

