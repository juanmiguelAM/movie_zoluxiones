package com.mancajima.movie_zoluxiones.data.network

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.mancajima.movie_zoluxiones.data.model.MovieResponseModel
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieResponseApiClient {
    //https://api.themoviedb.org/3/movie/upcoming?page=1&api_key=6c620844187050b529e568c6b878588b
    //https://api.themoviedb.org/3/search/movie?api_key=6c620844187050b529e568c6b878588b&query=harry potter&page=1

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(@Query("page") page:Int, @Query("api_key") api_key:String): Response<List<MovieResponseModel>>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovieV2(@Query("page") page:Int, @Query("api_key") api_key:String): Response<JsonObject>

    @GET()
    suspend fun getTest2(): Response<List<MovieResponseModel>>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie2(@Query("api_key") api_key:String): Response<List<MovieResponseModel>>

}