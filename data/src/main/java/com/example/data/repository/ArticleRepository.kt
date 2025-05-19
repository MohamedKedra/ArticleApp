package com.example.data.repository

import com.example.data.local.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    suspend fun getRemoteList() : List<ArticleEntity>

    fun getCachedArticles(): Flow<List<ArticleEntity>>
}