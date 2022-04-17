package com.eslamwaheed.mvvmdemo.di

import com.eslamwaheed.mvvmdemo.BuildConfig
import com.eslamwaheed.mvvmdemo.api.UnsplashService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideUnsplashService(): UnsplashService {
        val logger =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val client = if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
        } else {
            OkHttpClient.Builder()
                .build()
        }
        return Retrofit.Builder()
            .baseUrl(UnsplashService.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UnsplashService::class.java)
    }
}