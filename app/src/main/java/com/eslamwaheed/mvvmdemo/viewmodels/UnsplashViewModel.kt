package com.eslamwaheed.mvvmdemo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.eslamwaheed.mvvmdemo.data.models.entities.Photos
import com.eslamwaheed.mvvmdemo.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class UnsplashViewModel @Inject constructor(private val repository: UnsplashRepository) :
    ViewModel() {

    val unsplashSearchResponseLiveData =
        MutableLiveData<ArrayList<Photos?>?>()

    private var currentSearchResult: Flow<PagingData<Photos>>? = null

    init {
        //searchPictures("flower")
    }

    suspend fun searchPictures(query: String): Flow<PagingData<Photos>>? {
        return repository.getSearchResultStream(query)?.cachedIn(viewModelScope)
    }
}