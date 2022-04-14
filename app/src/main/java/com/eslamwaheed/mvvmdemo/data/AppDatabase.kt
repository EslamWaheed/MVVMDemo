package com.eslamwaheed.mvvmdemo.data

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.eslamwaheed.mvvmdemo.data.daos.PhotosDAO
import com.eslamwaheed.mvvmdemo.data.models.UnsplashSearchResponse

@Database(
    entities = [UnsplashSearchResponse.Result::class, UnsplashSearchResponse.Result.Urls::class],
    version = 2,
    exportSchema = true,
    autoMigrations = [AutoMigration(from = 1, to = 2)]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photosDao(): PhotosDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        val migration1To2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                TODO("Not yet implemented")
            }

        }

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "photos_database"
                )
                    .addMigrations(migration1To2)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}