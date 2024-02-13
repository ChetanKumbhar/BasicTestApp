package com.example.basictestapp.data.service

import com.example.basictestapp.data.module.NewsResponse
import com.example.basictestapp.util.Constants.API_KEY
import com.example.basictestapp.util.Constants.DEFAULT_PAGE_SIZE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") q:String = "india",
        @Query("page") page: Int = 2,
        @Query("size") size: Int = DEFAULT_PAGE_SIZE,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>
}