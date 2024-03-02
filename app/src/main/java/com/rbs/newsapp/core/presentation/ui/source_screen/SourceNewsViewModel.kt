package com.rbs.newsapp.core.presentation.ui.source_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rbs.newsapp.core.data.remote.model.Sources
import com.rbs.newsapp.core.domain.usecase.SourceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SourceNewsViewModel @Inject constructor(private val useCase: SourceUseCase) : ViewModel() {
    fun getSources(category: String) : LiveData<List<Sources>> = useCase.getSources(category).asLiveData()
}