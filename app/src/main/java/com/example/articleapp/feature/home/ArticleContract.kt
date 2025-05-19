package com.example.articleapp.feature.home

import com.example.data.local.ArticleEntity

sealed class ArticleEvent {
    data object FetchArticles : ArticleEvent()
}

sealed class ArticleState {
    data object Idle : ArticleState()
    data object Loading : ArticleState()
    data class Success(val articles: List<ArticleEntity>) : ArticleState()
    data class Error(val message: String) : ArticleState()
}