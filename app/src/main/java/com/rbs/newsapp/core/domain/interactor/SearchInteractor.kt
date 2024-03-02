package com.rbs.newsapp.core.domain.interactor

import androidx.paging.PagingData
import com.rbs.newsapp.core.data.remote.model.Articles
import com.rbs.newsapp.core.domain.repository.ISearchRepository
import com.rbs.newsapp.core.domain.usecase.SearchUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchInteractor @Inject constructor(private val repository: ISearchRepository) :
    SearchUseCase {
    override fun getArticles(query: String): Flow<PagingData<Articles>> =
        repository.getArticles(query)
}