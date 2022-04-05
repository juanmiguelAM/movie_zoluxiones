package com.mancajima.movie_zoluxiones.domain.model

import com.mancajima.movie_zoluxiones.data.model.MovieResponseModel

data class MovieResponse(
    val page:String,
    val results:List<Movie>,
    val total_pages:String,
    val total_results:String
)

fun MovieResponseModel.toDomain() = MovieResponse(page, results.map { it.toDomain() }, total_pages, total_results)