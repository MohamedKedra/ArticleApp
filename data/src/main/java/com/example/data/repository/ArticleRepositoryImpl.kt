package com.example.data.repository

import com.example.data.local.ArticleDao
import com.example.data.local.ArticleEntity
import com.example.data.local.toEntity
import com.example.data.network.ArticleService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val articleService: ArticleService,
    private val articleDao: ArticleDao
) : ArticleRepository {
    override suspend fun getRemoteList(): List<ArticleEntity> {
        val response = articleService.getRemoteList().data
        val articles = response?.articles?.map { it.toEntity() } ?: arrayListOf()
        articleDao.clearArticles()
        articleDao.insertArticles(articles)
        return articles
    }

    override fun getCachedArticles(): Flow<List<ArticleEntity>> = articleDao.getAllArticles()
}