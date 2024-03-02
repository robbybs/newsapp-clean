package com.rbs.newsapp.core.domain.repository

import com.rbs.newsapp.core.data.remote.model.Sources
import kotlinx.coroutines.flow.Flow

interface ISourceRepository {
    fun getSources(category: String): Flow<List<Sources>>
}