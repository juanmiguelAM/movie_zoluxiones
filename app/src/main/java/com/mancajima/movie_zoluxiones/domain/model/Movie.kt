package com.mancajima.movie_zoluxiones.domain.model

import com.mancajima.movie_zoluxiones.data.database.entities.MovieEntity
import com.mancajima.movie_zoluxiones.data.model.MovieModel

data class Movie (
    val id:String,
    val title:String,
    val poster_path:String?,
    val vote_average:String?,
    val release_date:String?,
    val overview:String?,
    val backdrop_path:String?
)

fun MovieModel.toDomain() = Movie(id, title, poster_path, vote_average, release_date, overview, backdrop_path)
fun MovieEntity.toDomain() = Movie(id, title, poster_path, vote_average, release_date, overview, backdrop_path)


