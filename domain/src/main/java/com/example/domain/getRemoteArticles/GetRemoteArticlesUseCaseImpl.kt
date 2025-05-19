package com.example.domain.getRemoteArticles

import com.example.data.local.ArticleEntity
import com.example.data.repository.ArticleRepository
import javax.inject.Inject

class GetRemoteArticlesUseCaseImpl @Inject constructor(
    private val articleRepository: ArticleRepository
) : GetRemoteArticlesUseCase{

    override suspend fun invoke(): List<ArticleEntity> {
        return articleRepository.getRemoteList()
    }
}