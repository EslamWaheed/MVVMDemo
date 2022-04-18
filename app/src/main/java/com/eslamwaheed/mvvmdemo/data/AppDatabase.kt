package com.eslamwaheed.mvvmdemo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eslamwaheed.mvvmdemo.data.daos.PhotosDAO
import com.eslamwaheed.mvvmdemo.data.models.entities.Photos
import com.eslamwaheed.mvvmdemo.data.models.entities.Urls

@Database(
    entities = [Photos::class, Urls::class],
    version = 1,
    exportSchema = false,
    //autoMigrations = [AutoMigration(from = 1, to = 2)]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photosDao(): PhotosDAO

    companion object {
//        val migration1To2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                TODO("Not yet implemented")
//            }
//        }
    }
}