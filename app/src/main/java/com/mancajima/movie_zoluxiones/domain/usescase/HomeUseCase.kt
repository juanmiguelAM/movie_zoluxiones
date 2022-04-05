package com.mancajima.movie_zoluxiones.domain.usescase

import android.util.Log
import com.mancajima.movie_zoluxiones.data.repository.MovieRepository
import com.mancajima.movie_zoluxiones.data.repository.MovieResponseRepository
import com.mancajima.movie_zoluxiones.data.database.entities.toDatabase
import com.mancajima.movie_zoluxiones.domain.model.Movie
import com.mancajima.movie_zoluxiones.domain.model.MovieResponse
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val repository: MovieResponseRepository, private val repositoryM: MovieRepository) {
    suspend fun getAllUpcomingMovies(page:Int): List<Movie> {
        val moviesList = repository.getAllUpcomingPage(page)
        return if(moviesList.isNotEmpty()){
            repositoryM.clearMovies()
            repositoryM.insertMovieUpcoming(moviesList.map { it.toDatabase() })
            moviesList
        }else{//return to db
            emptyList()
        }
    }

    suspend fun getAllUpcomingMoviesV2(page:Int): List<MovieResponse> {
        val movieResponse = repository.getAllUpcomingPageV2(page)
        return if(movieResponse.isNotEmpty()){
            Log.i("movieResponseUC", ""+movieResponse[0].total_pages)
            val moviesList = movieResponse[0].results
            repositoryM.clearMovies()
            repositoryM.insertMovieUpcoming(moviesList.map { it.toDatabase() })
            movieResponse?: emptyList()
        }else{//return to db
            val listMR = mutableListOf<MovieResponse>()
            val moviesList = repositoryM.getAllMoviesDatabase()

            if(moviesList.isNotEmpty()){
                listMR.add(MovieResponse("1", moviesList, "1", ""+moviesList.count()))
                listMR
            }else{
                emptyList()
            }
        }
    }
}