package com.example.domain.getCachedArticles

import com.example.data.local.ArticleEntity
import com.example.data.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCachedArticlesUseCaseImpl @Inject constructor(
    private val articleRepository: ArticleRepository
) : GetCachedArticlesUseCase {
    override fun invoke(): Flow<List<ArticleEntity>> {
        return articleRepository.getCachedArticles()
    }
}