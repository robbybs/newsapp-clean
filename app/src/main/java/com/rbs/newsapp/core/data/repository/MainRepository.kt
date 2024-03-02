package com.rbs.newsapp.core.data.repository

import com.rbs.newsapp.core.domain.repository.IMainRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor() : IMainRepository {
    override fun collectData(category: Array<String>): List<String> = category.toList()
}