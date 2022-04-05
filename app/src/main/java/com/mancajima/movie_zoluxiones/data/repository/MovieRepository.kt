package com.mancajima.movie_zoluxiones.data.repository

import com.mancajima.movie_zoluxiones.data.database.dao.MovieDao
import com.mancajima.movie_zoluxiones.data.database.entities.MovieEntity
import com.mancajima.movie_zoluxiones.domain.model.Movie
import com.mancajima.movie_zoluxiones.domain.model.toDomain
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieDao: MovieDao) {
    suspend fun insertMovieUpcoming(movies:List<MovieEntity>){
        movieDao.insertAllMovie(movies)
    }

    suspend fun clearMovies(){
        movieDao.deleteAllQuotes()
    }

    suspend fun getAllMoviesDatabase():List<Movie>{
        val response:List<MovieEntity> = movieDao.getAllMovieDatabase()
        return response.map { it.toDomain() }
    }
}