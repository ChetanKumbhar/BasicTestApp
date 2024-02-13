package com.example.basictestapp.ui.screens

import com.example.basictestapp.data.module.News

data class NewsState(
    val isLoading: Boolean = false,
    var news: List<News> = listOf(),
    val error: String = ""
    )

