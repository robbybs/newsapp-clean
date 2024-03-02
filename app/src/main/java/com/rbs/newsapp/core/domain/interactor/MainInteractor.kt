package com.rbs.newsapp.core.domain.interactor

import com.rbs.newsapp.core.domain.repository.IMainRepository
import com.rbs.newsapp.core.domain.usecase.MainUseCase
import javax.inject.Inject

class MainInteractor @Inject constructor(private val repository: IMainRepository) : MainUseCase {
    override fun collectData(category: Array<String>): List<String> =
        repository.collectData(category)
}