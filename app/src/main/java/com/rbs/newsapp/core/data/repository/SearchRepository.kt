package com.rbs.newsapp.core.data.repository

import androidx.paging.PagingData
import com.rbs.newsapp.core.data.remote.RemoteDataSource
import com.rbs.newsapp.core.data.remote.model.Articles
import com.rbs.newsapp.core.domain.repository.ISearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    ISearchRepository {
    override fun getArticles(query: String): Flow<PagingData<Articles>> =
        remoteDataSource.getSearchArticles(query)
}