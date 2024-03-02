package com.rbs.newsapp.core.domain.usecase

import com.rbs.newsapp.core.data.remote.model.Articles
import kotlinx.coroutines.flow.Flow

interface ArticleUseCase {
    fun getArticles(sources: String): Flow<List<Articles>>
}