package com.example.basictestapp.domain.repository

import com.example.basictestapp.data.module.News

interface NewsRepository {
    suspend fun getNewsList(): Result<List<News>>
    suspend fun getNewsDetail(id: Int): Result<News>
}