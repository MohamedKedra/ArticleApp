package com.example.domain.di

import com.example.data.repository.ArticleRepository
import com.example.domain.getCachedArticles.GetCachedArticlesUseCase
import com.example.domain.getCachedArticles.GetCachedArticlesUseCaseImpl
import com.example.domain.getRemoteArticles.GetRemoteArticlesUseCase
import com.example.domain.getRemoteArticles.GetRemoteArticlesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetRemoteArticlesUseCase(articleRepository: ArticleRepository) : GetRemoteArticlesUseCase{
        return GetRemoteArticlesUseCaseImpl(articleRepository)
    }

    @Provides
    fun provideGetCachedArticlesUseCase(articleRepository: ArticleRepository) : GetCachedArticlesUseCase {
        return GetCachedArticlesUseCaseImpl(articleRepository)
    }
}