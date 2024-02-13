package com.example.basictestapp.util

import android.content.Context
import com.example.basictestapp.data.module.Pet
import com.example.basictestapp.data.module.PetList
import com.google.gson.Gson

interface JsonHelper {
    companion object{
        fun getPets(context: Context): List<Pet> {
            val gson = Gson()
            val jsonData = context.assets.readAssetsFile("pets.json")

            // Parse the top-level object
            val topLevelObject = gson.fromJson(jsonData, PetList::class.java)

            // Extract the list of items from categories
            return topLevelObject.pets
        }
    }

}