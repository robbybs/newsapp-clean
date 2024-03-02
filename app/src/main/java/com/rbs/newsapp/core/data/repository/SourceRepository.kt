package com.rbs.newsapp.core.data.repository

import com.rbs.newsapp.core.data.remote.RemoteDataSource
import com.rbs.newsapp.core.data.remote.model.Sources
import com.rbs.newsapp.core.domain.repository.ISourceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SourceRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    ISourceRepository {
    override fun getSources(category: String): Flow<List<Sources>> =
        remoteDataSource.getSources(category)
}