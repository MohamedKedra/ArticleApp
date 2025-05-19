package com.example.data.di

import com.example.data.local.ArticleDao
import com.example.data.network.ArticleService
import com.example.data.repository.ArticleRepository
import com.example.data.repository.ArticleRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(articleService: ArticleService,articleDao: ArticleDao) : ArticleRepository =
        ArticleRepositoryImpl(articleService,articleDao)
}