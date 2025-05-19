package com.example.domain.getCachedArticles

import com.example.data.local.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface GetCachedArticlesUseCase {
    fun invoke() : Flow<List<ArticleEntity>>
}