package com.eslamwaheed.mvvmdemo.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class UnsplashSearchResponse(
    @SerializedName("total")
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("results")
    val results: ArrayList<Result?>?
) {
    @Entity
    data class Result(
        @PrimaryKey
        @SerializedName("id")
        val id: String?,
        @SerializedName("width")
        val width: Int?,
        @SerializedName("height")
        val height: Int?,
        @SerializedName("description")
        val description: Any?,
        @SerializedName("alt_description")
        val altDescription: String?,
        @SerializedName("urls")
        val urls: Urls?
    ) {
        @Entity
        data class Urls(
            @SerializedName("full")
            val full: String?,
            @SerializedName("regular")
            val regular: String?,
            @SerializedName("small")
            val small: String?,
        )
    }
}