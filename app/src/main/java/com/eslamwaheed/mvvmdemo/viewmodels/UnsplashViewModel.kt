package com.eslamwaheed.mvvmdemo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eslamwaheed.mvvmdemo.data.models.entities.Photos
import com.eslamwaheed.mvvmdemo.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnsplashViewModel @Inject constructor(private val repository: UnsplashRepository) :
    ViewModel() {

    val unsplashSearchResponseLiveData =
        MutableLiveData<ArrayList<Photos?>?>()

    init {
        searchPictures("flower")
    }

    fun searchPictures(query: String, pageNumber: Int = 10) {
        viewModelScope.launch(IO) {
            with(repository.getSearchResultStream(query, pageNumber)) {
                unsplashSearchResponseLiveData.postValue(this)
            }
        }
    }
}