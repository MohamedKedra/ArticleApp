package com.example.articleapp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repository.ArticleRepository
import com.example.data.utils.ConnectionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
    private val connectionManager: ConnectionManager
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
            if (connectionManager.isNetworkAvailable) {
                try {
                    val articles = articleRepository.getRemoteList()
                    _state.value = ArticleState.Success(articles)
                } catch (e: Exception) {
                    _state.value = ArticleState.Error(e.message ?: "Unknown error")
                }
            }else{
                val articles = articleRepository.getCachedArticles()
                articles.collectLatest {
                    _state.value = ArticleState.Success(it)
                }
            }
        }
    }
}