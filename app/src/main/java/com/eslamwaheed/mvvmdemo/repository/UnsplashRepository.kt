package com.eslamwaheed.mvvmdemo.repository

import com.eslamwaheed.mvvmdemo.api.UnsplashService
import com.eslamwaheed.mvvmdemo.data.UnsplashSearchResponse
import javax.inject.Inject

class UnsplashRepository @Inject constructor(private val service: UnsplashService) {
    suspend fun getSearchResultStream(query: String, pageNumber: Int): UnsplashSearchResponse {
        return service.searchPhotos(query, pageNumber, NETWORK_PAGE_SIZE)
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 5
    }
}