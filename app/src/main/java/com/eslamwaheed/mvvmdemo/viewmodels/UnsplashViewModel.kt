package com.eslamwaheed.mvvmdemo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eslamwaheed.mvvmdemo.data.models.UnsplashSearchResponse
import com.eslamwaheed.mvvmdemo.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnsplashViewModel @Inject constructor(private val repository: UnsplashRepository) :
    ViewModel() {

    val unsplashSearchResponseLiveData = MutableLiveData<UnsplashSearchResponse>()

    val photosLiveData = MutableLiveData<ArrayList<UnsplashSearchResponse.Result>>()

    fun searchPictures(query: String) {
        viewModelScope.launch(IO) {
            repository.getSearchResultStream(query).apply {
                unsplashSearchResponseLiveData.postValue(this)
            }
        }
    }

    suspend fun insertPhoto(result: UnsplashSearchResponse.Result) {
        viewModelScope.launch(IO) {
            repository.insertPhoto(result)
        }
    }

    suspend fun deletePhoto(result: UnsplashSearchResponse.Result) {
        viewModelScope.launch(IO) {
            repository.deletePhoto(result)
        }
    }

    suspend fun getAllPhotos() {
        viewModelScope.launch(IO) {
            repository.getAllPhotos().apply {
                photosLiveData.postValue(this)
            }
        }
    }
}