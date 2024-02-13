package com.example.basictestapp.domain.usecases.news


import com.example.basictestapp.data.module.News
import com.example.basictestapp.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsDetailUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend fun getNewsDetail(id: Int): Result<News> {
        return newsRepository.getNewsDetail(id)
    }
}

