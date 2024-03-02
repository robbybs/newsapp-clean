package com.rbs.newsapp.core.data.repository

import com.rbs.newsapp.core.data.remote.RemoteDataSource
import com.rbs.newsapp.core.data.remote.model.Articles
import com.rbs.newsapp.core.domain.repository.IArticleRepository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    IArticleRepository {
    override fun getArticles(sources: String): Flow<List<Articles>> =
        remoteDataSource.getArticles(sources)
}