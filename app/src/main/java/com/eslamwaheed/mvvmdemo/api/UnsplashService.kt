package com.eslamwaheed.mvvmdemo.api

import com.eslamwaheed.mvvmdemo.BuildConfig
import com.eslamwaheed.mvvmdemo.data.UnsplashSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashService {

    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("client_id") clientId: String = BuildConfig.UNSPLASH_ACCESS_KEY
    ): UnsplashSearchResponse

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
    }
}