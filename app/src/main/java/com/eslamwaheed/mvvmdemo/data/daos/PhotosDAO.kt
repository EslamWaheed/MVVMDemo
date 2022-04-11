package com.eslamwaheed.mvvmdemo.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.eslamwaheed.mvvmdemo.data.models.UnsplashSearchResponse

@Dao
interface PhotosDAO {

    @Insert
    suspend fun insertPhoto(result: UnsplashSearchResponse.Result)

    @Delete()
    suspend fun deletePhoto(result: UnsplashSearchResponse.Result)

    @Query("select * from Result")
    suspend fun getAllPhotos(): List<UnsplashSearchResponse.Result>
}