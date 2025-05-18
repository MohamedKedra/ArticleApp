package com.example.data.network

import retrofit2.http.GET

interface ArticleService {

    @GET("/r/kotlin/.json")
    suspend fun getRemoteList()  : ArticleResponse
}