package com.rbs.newsapp.core.data.remote.network

import com.rbs.newsapp.core.data.remote.model.ArticlesResponse
import com.rbs.newsapp.core.data.remote.model.SourcesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines/sources")
    suspend fun getSourceNews(
        @Query("category") category: String,
        @Query("apiKey") key: String
    ): SourcesResponse

    @GET("top-headlines")
    suspend fun getArticles(
        @Query("sources") sources: String,
        @Query("apiKey") key: String
    ): ArticlesResponse

    @GET("everything")
    suspend fun getSearchArticles(
        @Query("q") q: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") key: String
    ): ArticlesResponse
}