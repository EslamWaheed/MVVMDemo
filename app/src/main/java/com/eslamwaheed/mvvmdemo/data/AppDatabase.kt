package com.eslamwaheed.mvvmdemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eslamwaheed.mvvmdemo.data.daos.PhotosDAO
import com.eslamwaheed.mvvmdemo.data.models.UnsplashSearchResponse

@Database(
    entities = [UnsplashSearchResponse.Result::class, UnsplashSearchResponse.Result.Urls::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photosDao(): PhotosDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "photos_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}