package com.eslamwaheed.mvvmdemo.repository

import com.eslamwaheed.mvvmdemo.api.UnsplashService
import com.eslamwaheed.mvvmdemo.data.daos.PhotosDAO
import com.eslamwaheed.mvvmdemo.data.models.UnsplashSearchResponse
import javax.inject.Inject

class UnsplashRepository @Inject constructor(
    private val service: UnsplashService,
    private val dao: PhotosDAO
) {
    suspend fun getSearchResultStream(query: String): UnsplashSearchResponse {
        return service.searchPhotos(query, 1, NETWORK_PAGE_SIZE)
    }

    suspend fun insertPhoto(result: UnsplashSearchResponse.Result) {
        dao.insertPhoto(result)
    }

    suspend fun deletePhoto(result: UnsplashSearchResponse.Result) {
        dao.deletePhoto(result)
    }

    suspend fun getAllPhotos(): ArrayList<UnsplashSearchResponse.Result> {
        return dao.getAllPhotos() as ArrayList<UnsplashSearchResponse.Result>
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 5
    }
}