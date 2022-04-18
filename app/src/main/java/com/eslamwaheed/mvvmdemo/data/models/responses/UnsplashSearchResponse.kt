package com.eslamwaheed.mvvmdemo.data.models.responses

import com.eslamwaheed.mvvmdemo.data.models.entities.Photos
import com.google.gson.annotations.SerializedName

data class UnsplashSearchResponse(
    @SerializedName("total")
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("results")
    val photos: ArrayList<Photos?>?
)