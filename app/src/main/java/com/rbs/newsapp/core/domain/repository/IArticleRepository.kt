package com.rbs.newsapp.core.domain.repository

import com.rbs.newsapp.core.data.remote.model.Articles
import kotlinx.coroutines.flow.Flow

interface IArticleRepository {
    fun getArticles(sources: String): Flow<List<Articles>>
}