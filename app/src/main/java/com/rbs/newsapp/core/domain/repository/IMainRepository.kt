package com.rbs.newsapp.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface IMainRepository {
    fun collectData(category: Array<String>): List<String>
}