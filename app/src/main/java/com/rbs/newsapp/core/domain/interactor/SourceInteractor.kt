package com.rbs.newsapp.core.domain.interactor

import com.rbs.newsapp.core.data.remote.model.Sources
import com.rbs.newsapp.core.domain.repository.ISourceRepository
import com.rbs.newsapp.core.domain.usecase.SourceUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SourceInteractor @Inject constructor(private val repository: ISourceRepository) :
    SourceUseCase {
    override fun getSources(category: String): Flow<List<Sources>> =
        repository.getSources(category)
}