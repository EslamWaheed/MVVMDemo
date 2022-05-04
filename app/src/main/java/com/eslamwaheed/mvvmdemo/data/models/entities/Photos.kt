package com.eslamwaheed.mvvmdemo.data.models.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Photos(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "result_id")
    val result_id: Int,
    @SerializedName("width")
    @Expose(serialize = true, deserialize = true)
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
)
