package com.example.basictestapp.data.repository

import android.content.Context
import com.example.basictestapp.data.module.Pet
import com.example.basictestapp.domain.repository.PetsRepository
import com.example.basictestapp.util.JsonHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PetsRepositoryImpl : PetsRepository {
    override fun getPets(context: Context): Flow<List<Pet>> {
       return  flow {
                val latestNews = JsonHelper.getPets(context)
                emit(latestNews) // Emits the result of the request to the flow
            }
    }

    override suspend fun getPetByTitle(title: String): Pet? {
        TODO("Not yet implemented")
    }
}