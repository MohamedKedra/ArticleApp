package com.example.data.repository

import com.example.data.network.Article

interface ArticleRepository {
    suspend fun getRemoteList() : List<Article>
}