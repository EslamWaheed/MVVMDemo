package com.eslamwaheed.mvvmdemo.di

import android.content.Context
import androidx.room.Room
import com.eslamwaheed.mvvmdemo.data.AppDatabase
import com.eslamwaheed.mvvmdemo.data.daos.PhotosDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "photos_database"
            )
                //.addMigrations(migration1To2)
                .build()
            instance
        }
    }

    @Provides
    fun photosDAO(appDatabase: AppDatabase): PhotosDAO {
        return appDatabase.photosDao()
    }
}