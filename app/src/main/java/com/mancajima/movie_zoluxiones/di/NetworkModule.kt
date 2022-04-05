package com.mancajima.movie_zoluxiones.di

import com.mancajima.movie_zoluxiones.data.network.MovieResponseApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/").addConverterFactory(
            GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit):MovieResponseApiClient{
        return retrofit.create(MovieResponseApiClient::class.java)
    }
}