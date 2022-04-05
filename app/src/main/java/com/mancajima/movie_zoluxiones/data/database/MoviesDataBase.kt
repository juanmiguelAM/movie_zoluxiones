package com.mancajima.movie_zoluxiones.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mancajima.movie_zoluxiones.data.database.dao.MovieDao
import com.mancajima.movie_zoluxiones.data.database.dao.UserDao
import com.mancajima.movie_zoluxiones.data.database.entities.MovieEntity
import com.mancajima.movie_zoluxiones.data.database.entities.UserEntity

@Database(entities = [UserEntity::class, MovieEntity::class], version = 1)
abstract class MoviesDataBase : RoomDatabase(){
    abstract fun getUserDao():UserDao
    abstract fun getMovieDao():MovieDao
}