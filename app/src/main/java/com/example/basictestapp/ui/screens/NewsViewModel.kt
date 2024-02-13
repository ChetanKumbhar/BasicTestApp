package com.example.basictestapp.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basictestapp.domain.usecases.news.GetNewsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsListUseCase: GetNewsListUseCase
) :  LifecycleObserver, ViewModel() {
    val newsListState = mutableStateOf(NewsState())

    fun getNewsList() {
        viewModelScope.launch {

            // Show loading
            //newsListState.value = newsListState.value.copy(isLoading = true)
            val result =  getNewsListUseCase.getNewsList()

            result.getOrNull()?.let { value ->
                newsListState.value = newsListState.value.copy(news = value, isLoading = false)
            }
            result.exceptionOrNull()?.let { error ->
                newsListState.value = error.message?.let { newsListState.value.copy(error = it) }!!
            }
        }
    }
}