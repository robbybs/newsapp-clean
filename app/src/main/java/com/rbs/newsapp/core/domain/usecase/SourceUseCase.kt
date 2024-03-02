package com.rbs.newsapp.core.domain.usecase

import com.rbs.newsapp.core.data.remote.model.Sources
import kotlinx.coroutines.flow.Flow

interface SourceUseCase {
    fun getSources(category: String): Flow<List<Sources>>
}