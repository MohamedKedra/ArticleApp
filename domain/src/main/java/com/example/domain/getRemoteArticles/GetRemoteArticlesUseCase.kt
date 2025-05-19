package com.example.domain.getRemoteArticles

import com.example.data.local.ArticleEntity

interface GetRemoteArticlesUseCase {

    suspend fun invoke() : List<ArticleEntity>
}