package com.mancajima.movie_zoluxiones.data.network

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.mancajima.movie_zoluxiones.data.model.MovieModel
import com.mancajima.movie_zoluxiones.data.model.MovieResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.lang.Exception
import javax.inject.Inject

class MovieResponseService @Inject constructor(private val api:MovieResponseApiClient) {
    suspend fun getMovieResponse(page:Int):List<MovieModel>{
        return withContext(Dispatchers.IO){
            try {
                val response = api.getUpcomingMovieV2(page, "6c620844187050b529e568c6b878588b")

                val gson = Gson()
                val json:JsonObject = response.body()!!
                val page = json.get("page")
                val results = gson.fromJson(json.get("results"), Array<MovieModel>::class.java).asList()
                val total_pages = json.get("total_pages")
                val total_results = json.get("total_results")

                Log.i("response", ""+json)
                Log.i("response", ""+page)
                Log.i("response", ""+results[0])
                Log.i("response", ""+total_pages)
                Log.i("response", ""+total_results)

                results?: emptyList()
            }catch (e:Exception){//Ocurrió un error
                Log.i("MOVIERESPONSERVICE", ""+e.message)
                emptyList()
            }
        }
    }

    suspend fun getMovieResponseV2(page:Int):List<MovieResponseModel>{
        return withContext(Dispatchers.IO){
            try {
                val response = api.getUpcomingMovieV2(page, "6c620844187050b529e568c6b878588b")

                val gson = Gson()
                val json:JsonObject = response.body()!!
                val page = json.get("page")
                val results = gson.fromJson(json.get("results"), Array<MovieModel>::class.java).asList()
                val total_pages = json.get("total_pages")
                val total_results = json.get("total_results")

                Log.i("response", ""+json)
                Log.i("response", ""+page)
                Log.i("response", ""+results[0])
                Log.i("response", ""+total_pages)
                Log.i("response", ""+total_results)

                val listMRM = mutableListOf<MovieResponseModel>()
                listMRM.add(MovieResponseModel(page.toString(), results?: emptyList(), total_pages.toString(), total_results.toString()))
                Log.i("MOVIERESPONSERVICE", ""+listMRM[0])
                listMRM?.toList()?: emptyList()
            }catch (e:Exception){//Ocurrió un error
                Log.i("MOVIERESPONSERVICE", ""+e.message)
                emptyList()
            }
        }
    }
}