package com.eslamwaheed.mvvmdemo.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.eslamwaheed.mvvmdemo.data.models.entities.Photos

@Dao
interface PhotosDAO {

    @Insert
    suspend fun insertPhoto(photos: Photos?)

    @Delete
    suspend fun deletePhoto(photos: Photos)

    @Query("select * from Photos")
    suspend fun getAllPhotos(): List<Photos?>?
}