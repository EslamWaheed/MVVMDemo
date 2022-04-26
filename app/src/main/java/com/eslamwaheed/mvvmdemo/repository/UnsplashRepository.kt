package com.eslamwaheed.mvvmdemo.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.eslamwaheed.mvvmdemo.api.UnsplashService
import com.eslamwaheed.mvvmdemo.data.daos.PhotosDAO
import com.eslamwaheed.mvvmdemo.data.models.entities.Photos
import com.eslamwaheed.mvvmdemo.data.pagingsource.PhotosPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UnsplashRepository @Inject constructor(
    private val service: UnsplashService,
    private val dao: PhotosDAO
) {
    suspend fun getSearchResultStream(query: String): Flow<PagingData<Photos>>? {
        return try {
            Pager(
                config = PagingConfig(enablePlaceholders = false, pageSize = NETWORK_PAGE_SIZE),
                pagingSourceFactory = { PhotosPagingSource(service, query) }
            ).flow
        } catch (e: Exception) {
            null
        }
        /*
        val photosList: ArrayList<Photos?>? =
            try {
//                service.searchPhotos(query, pageNumber, NETWORK_PAGE_SIZE).apply {
//                    val result = this?.photos
//                    result?.forEach {
//                        insertPhoto(it)
//                    }
//                }?.photos
            } catch (e: Exception) {
                getAllPhotos()
            }
         */
    }

    private suspend fun insertPhoto(photos: Photos?) {
        dao.insertPhoto(photos)
    }

    private suspend fun deletePhoto(photos: Photos) {
        dao.deletePhoto(photos)
    }

    private suspend fun getAllPhotos(): ArrayList<Photos?>? {
        return dao.getAllPhotos() as ArrayList<Photos?>?
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 5
    }
}