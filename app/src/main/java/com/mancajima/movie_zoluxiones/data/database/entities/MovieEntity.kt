package com.mancajima.movie_zoluxiones.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mancajima.movie_zoluxiones.domain.model.Movie

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id:String,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "poster_path") val poster_path:String?,
    @ColumnInfo(name = "vote_average") val vote_average:String?,
    @ColumnInfo(name = "release_date") val release_date:String?,
    @ColumnInfo(name = "overview") val overview:String?,
    @ColumnInfo(name = "backdrop_path") val backdrop_path:String?
)

fun Movie.toDatabase() = MovieEntity(id = id, title = title, poster_path = poster_path, vote_average = vote_average, release_date = release_date, overview= overview, backdrop_path=backdrop_path)