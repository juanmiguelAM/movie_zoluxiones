package com.mancajima.movie_zoluxiones.data.repository

import com.mancajima.movie_zoluxiones.data.model.MovieModel
import com.mancajima.movie_zoluxiones.data.model.MovieResponseModel
import com.mancajima.movie_zoluxiones.data.network.MovieResponseService
import com.mancajima.movie_zoluxiones.domain.model.Movie
import com.mancajima.movie_zoluxiones.domain.model.MovieResponse
import com.mancajima.movie_zoluxiones.domain.model.toDomain
import javax.inject.Inject

class MovieResponseRepository @Inject constructor(
    private val api:MovieResponseService
){
    suspend fun getAllUpcomingPage(page:Int): List<Movie> {
        val response:List<MovieModel> = api.getMovieResponse(page)
        return response.map { it.toDomain() }
    }

    suspend fun getAllUpcomingPageV2(page:Int): List<MovieResponse> {
        val response:List<MovieResponseModel> = api.getMovieResponseV2(page)
        return response.map { it.toDomain() }
    }
}