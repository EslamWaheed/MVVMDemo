package com.eslamwaheed.mvvmdemo.data.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Urls(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "url_id")
    val urlID: Int,
    @SerializedName("full")
    val full: String?,
    @SerializedName("regular")
    val regular: String?,
    @SerializedName("small")
    val small: String?
)
