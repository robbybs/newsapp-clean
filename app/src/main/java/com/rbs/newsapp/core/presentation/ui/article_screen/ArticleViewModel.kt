package com.rbs.newsapp.core.presentation.ui.article_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rbs.newsapp.core.data.remote.model.Articles
import com.rbs.newsapp.core.domain.usecase.ArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val useCase: ArticleUseCase) : ViewModel() {
    fun getArticles(sources: String) : LiveData<List<Articles>> = useCase.getArticles(sources).asLiveData()
}