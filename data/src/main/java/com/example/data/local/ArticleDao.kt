package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(articles: List<ArticleEntity>)

    @Query("SELECT * FROM articles_items")
    fun getAllArticles(): Flow<List<ArticleEntity>>

    @Query("DELETE FROM articles_items")
    fun clearArticles()
}