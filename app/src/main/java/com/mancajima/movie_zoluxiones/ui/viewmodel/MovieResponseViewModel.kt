package com.mancajima.movie_zoluxiones.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mancajima.movie_zoluxiones.domain.usescase.HomeUseCase
import com.mancajima.movie_zoluxiones.domain.model.Movie
import com.mancajima.movie_zoluxiones.domain.model.MovieResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieResponseViewModel @Inject constructor(
    private val getHomeUseCase: HomeUseCase
):ViewModel(){
    //val movieList = MutableLiveData<MovieResponse>()
    val isLoading = MutableLiveData<Boolean>()
    val movieList = MutableLiveData<List<Movie>>()
    val movieResponse = MutableLiveData<List<MovieResponse>>()

    fun getMovieListResponse(page:Int){
        viewModelScope.launch{
            isLoading.postValue(true)
            val result = getHomeUseCase.getAllUpcomingMovies(page)
            movieList.postValue(result)
            if(!result.isNullOrEmpty()){
                Log.i("RESPONSE", result.toString())
            }else{
                Log.i("RESPONSE", "VACIO")
            }
            //delay(2000)
            isLoading.postValue(false)
        }
    }

    fun getMovieListResponseV2(page:Int){
        viewModelScope.launch{
            isLoading.postValue(true)
            val result = getHomeUseCase.getAllUpcomingMoviesV2(page)
            movieResponse.postValue(result)
            if(!result.isNullOrEmpty()){
                Log.i("RESPONSE", result.toString())
            }else{
                Log.i("RESPONSE", "VACIO")
            }
            //delay(2000)
            isLoading.postValue(false)
        }
    }
}