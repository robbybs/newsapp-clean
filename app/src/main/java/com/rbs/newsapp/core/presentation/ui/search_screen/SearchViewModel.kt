package com.rbs.newsapp.core.presentation.ui.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.rbs.newsapp.core.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val useCase: SearchUseCase) : ViewModel() {
    fun search(query: String) = useCase.getArticles(query).cachedIn(viewModelScope).asLiveData()
}