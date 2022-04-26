package com.eslamwaheed.mvvmdemo.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.eslamwaheed.mvvmdemo.api.UnsplashService
import com.eslamwaheed.mvvmdemo.data.models.entities.Photos

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class PhotosPagingSource(
    private val service: UnsplashService,
    private val query: String
) : PagingSource<Int, Photos>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photos> {
        val page = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
        return try {
            val response = service.searchPhotos(query, page, params.loadSize)
            val photos = response.photos
            LoadResult.Page(
                data = photos,
                prevKey = if (page == UNSPLASH_STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (page == response.totalPages) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photos>): Int? {
        TODO("Not yet implemented")
    }
}