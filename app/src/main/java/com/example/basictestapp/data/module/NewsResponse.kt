package com.example.basictestapp.data.module


data class NewsResponse(
    val status: String?,
    val totalResults: Int?,
    val articles: List<News>?,
)