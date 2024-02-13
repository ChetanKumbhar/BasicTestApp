package com.example.basictestapp.data.repository

import com.example.basictestapp.data.module.News
import com.example.basictestapp.data.module.RequestException
import com.example.basictestapp.data.service.NewsService
import com.example.basictestapp.domain.repository.NewsRepository
import java.net.HttpURLConnection

class NewsRepositoryImpl(
    private val newsService: NewsService
): NewsRepository {
    override suspend fun getNewsList(): Result<List<News>> {
        val apiResponse = newsService.getNews().body()
        if (apiResponse?.status == "ok") {
            val newsList = apiResponse.articles ?: emptyList()
            return Result.success(newsList)
        }

        return Result.failure(
            RequestException(
                code = HttpURLConnection.HTTP_INTERNAL_ERROR,
                message = "An error occurred!"
            )
        )
    }

    override suspend fun getNewsDetail(id: Int): Result<News> {
        TODO("Not yet implemented")
    }
}