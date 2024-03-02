package com.rbs.newsapp.core.domain.repository

import androidx.paging.PagingData
import com.rbs.newsapp.core.data.remote.model.Articles
import kotlinx.coroutines.flow.Flow

interface ISearchRepository {
    fun getArticles(query: String): Flow<PagingData<Articles>>
}