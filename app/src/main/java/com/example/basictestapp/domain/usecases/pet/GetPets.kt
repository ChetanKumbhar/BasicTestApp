package com.example.basictestapp.domain.usecases.pet

import android.content.Context
import com.example.basictestapp.data.module.Pet
import com.example.basictestapp.domain.repository.PetsRepository
import kotlinx.coroutines.flow.Flow

class GetPets(private val context: Context , private val repository: PetsRepository) {

    operator fun invoke(): Flow<List<Pet>> {
        return repository.getPets(context = context)
    }
}