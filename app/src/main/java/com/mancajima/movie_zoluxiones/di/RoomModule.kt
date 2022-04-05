package com.mancajima.movie_zoluxiones.di

import android.content.Context
import androidx.room.Room
import com.mancajima.movie_zoluxiones.data.database.MoviesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
class RoomModule {
    private val MOVIE_DATABASE_NAME = "moviesz_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, MoviesDataBase::class.java, MOVIE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideUserDao(db:MoviesDataBase)=db.getUserDao()

    @Singleton
    @Provides
    fun providerMovieDao(db:MoviesDataBase)=db.getMovieDao()
}