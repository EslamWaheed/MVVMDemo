package com.eslamwaheed.mvvmdemo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eslamwaheed.mvvmdemo.data.UnsplashSearchResponse
import com.eslamwaheed.mvvmdemo.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnsplashViewModel @Inject constructor(private val repository: UnsplashRepository) :
    ViewModel() {

    val unsplashSearchResponseLiveData = MutableLiveData<UnsplashSearchResponse>()

    fun searchPictures(query: String) {
        viewModelScope.launch(IO) {
            repository.getSearchResultStream(query).apply {
                unsplashSearchResponseLiveData.postValue(this)
            }
        }
    }
}