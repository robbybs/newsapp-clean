package com.rbs.newsapp.core.domain.usecase

import androidx.paging.PagingData
import com.rbs.newsapp.core.data.remote.model.Articles
import kotlinx.coroutines.flow.Flow

interface SearchUseCase {
    fun getArticles(query: String): Flow<PagingData<Articles>>
}