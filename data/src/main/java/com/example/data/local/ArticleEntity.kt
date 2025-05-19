package com.example.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.network.Article
import com.example.data.utils.Constants
import com.example.data.utils.Helper

@Entity(tableName = Constants.TABLE_NAME)
data class ArticleEntity(
    @PrimaryKey var id: String = Helper.getRandomString(4),
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "thumbnail") val thumbnail: String? = "",
    @ColumnInfo(name = "description") val description: String? = "",
    @ColumnInfo(name = "authorName") val authorName: String? = "",
    @ColumnInfo(name = "link") val link: String? = "",
)

fun Article.toEntity() : ArticleEntity {
    return ArticleEntity(
        authorName = articleDetails?.author ?: "",
        title = articleDetails?.title ?: "",
        thumbnail = articleDetails?.thumbnail ?: "",
        description = articleDetails?.selftext ?: "",
        link = articleDetails?.linkFlairText ?: ""
    )
}