package com.eslamwaheed.mvvmdemo.data.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
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
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "result_id")
        val result_id: Int,
        @SerializedName("width")
        val width: Int?,
        @SerializedName("height")
        val height: Int?,
        @SerializedName("description")
        val description: String?,
        @SerializedName("alt_description")
        val altDescription: String?,
        @Embedded
        @SerializedName("urls")
        val urls: Urls?
    ) {
        @Entity
        data class Urls(
            @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "url_id")
            val urlID: Int,
            @SerializedName("full")
            val full: String?,
            @SerializedName("regular")
            val regular: String?,
            @SerializedName("small")
            val small: String?,
        )
    }
}