package com.mancajima.movie_zoluxiones.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mancajima.movie_zoluxiones.data.database.entities.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT id, title, poster_path, vote_average, release_date, overview, backdrop_path FROM movie_table WHERE title LIKE :param1 ORDER BY title")
    suspend fun getSearchDatabase(param1:String):List<MovieEntity>

    @Query("SELECT id, title, poster_path, vote_average, release_date, overview, backdrop_path FROM movie_table ORDER BY title")
    suspend fun getAllMovieDatabase():List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovie(movies:List<MovieEntity>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllQuotes()
}