package com.example.basictestapp.domain.usecases.news

import com.example.basictestapp.data.module.News
import com.example.basictestapp.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsListUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    suspend fun getNewsList(): Result<List<News>> {
        return newsRepository.getNewsList()
    }
}