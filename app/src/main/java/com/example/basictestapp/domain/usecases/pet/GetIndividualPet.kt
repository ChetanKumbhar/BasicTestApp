package com.example.basictestapp.domain.usecases.pet

import com.example.basictestapp.data.module.Pet
import com.example.basictestapp.domain.repository.PetsRepository

class GetIndividualPet(private val repository: PetsRepository) {
    suspend operator fun invoke(title: String): Pet? {
        return repository.getPetByTitle(title)
    }
}