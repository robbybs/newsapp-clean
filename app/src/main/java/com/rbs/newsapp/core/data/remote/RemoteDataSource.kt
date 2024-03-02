package com.rbs.newsapp.core.data.remote

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rbs.newsapp.BuildConfig
import com.rbs.newsapp.core.data.remote.model.Articles
import com.rbs.newsapp.core.data.remote.model.Sources
import com.rbs.newsapp.core.data.remote.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    fun getArticles(sources: String): Flow<List<Articles>> = flow {
        try {
            emit(apiService.getArticles(sources, BuildConfig.KEY).articles)
        } catch (exception: Exception) {
            Log.e("Error get data: ", exception.message.toString())
        }
    }.flowOn(Dispatchers.IO)

    fun getSearchArticles(query: String): Flow<PagingData<Articles>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10
            ),
            pagingSourceFactory = {
                ArticlesPagingSource(query, apiService)
            }
        ).flow.flowOn(Dispatchers.IO)
    }

    fun getSources(category: String): Flow<List<Sources>> = flow {
        try {
            emit(apiService.getSourceNews(category, BuildConfig.KEY).sources)
        } catch (exception: Exception) {
            Log.e("Error get data: ", exception.message.toString())
        }
    }.flowOn(Dispatchers.IO)
}