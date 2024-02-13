package com.example.basictestapp.data.module

import com.google.gson.annotations.SerializedName
import java.util.Date


data class PetList(
    val pets: List<Pet>
)

data class Pet(
    val title : String,
    @SerializedName("image_url")
    val imageUrl : String,
    @SerializedName("content_url")
    val contentUrl : String,
    @SerializedName("date_added")
    val dateAdded : Date

)
