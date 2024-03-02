package com.rbs.newsapp.core.presentation.ui.home_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.rbs.newsapp.core.domain.usecase.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: MainUseCase) : ViewModel() {
    private val listCategory = MutableLiveData<List<String>>()
    var category: LiveData<List<String>> = listCategory

    fun getData(data: Array<String>) {
        viewModelScope.launch {
            listCategory.postValue(useCase.collectData(data))
        }
    }

    //fun getCategory(data: Array<String>) = useCase.collectData(data).asLiveData()
}