package com.example.data.repository

import com.example.data.network.Article
import com.example.data.network.ArticleService
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val articleService: ArticleService
) : ArticleRepository {
    override suspend fun getRemoteList(): List<Article> =
        articleService.getRemoteList().data?.articles ?: arrayListOf()
}