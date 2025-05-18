package com.example.articleapp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val articleRepository: ArticleRepository
) : ViewModel() {
    private val _state = MutableStateFlow<ArticleState>(ArticleState.Idle)
    val state: StateFlow<ArticleState> = _state.asStateFlow()

    fun onEvent(event: ArticleEvent) {
        when (event) {
            is ArticleEvent.FetchArticles -> fetchNews()
        }
    }

    private fun fetchNews() {
        viewModelScope.launch {
            _state.value = ArticleState.Loading
            try {
                val articles = articleRepository.getRemoteList()
                _state.value = ArticleState.Success(articles)
            } catch (e: Exception) {
                _state.value = ArticleState.Error(e.message ?: "Unknown error")
            }
        }
    }
}