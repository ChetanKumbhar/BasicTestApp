package com.example.basictestapp.domain.repository

import android.content.Context
import com.example.basictestapp.data.module.Pet
import kotlinx.coroutines.flow.Flow

interface PetsRepository {
    fun getPets(context: Context): Flow<List<Pet>>
    suspend fun getPetByTitle(title: String): Pet?
}