package com.rbs.newsapp.core.domain.usecase

import kotlinx.coroutines.flow.Flow

interface MainUseCase {
    fun collectData(category: Array<String>): List<String>
}