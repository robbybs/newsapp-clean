package com.rbs.newsapp.core.domain.interactor

import com.rbs.newsapp.core.data.remote.model.Articles
import com.rbs.newsapp.core.domain.repository.IArticleRepository
import com.rbs.newsapp.core.domain.usecase.ArticleUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleInteractor @Inject constructor(private val repository: IArticleRepository) :
    ArticleUseCase {
    override fun getArticles(sources: String): Flow<List<Articles>> =
        repository.getArticles(sources)
}