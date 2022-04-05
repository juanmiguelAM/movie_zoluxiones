package com.mancajima.movie_zoluxiones.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponseModel (
    @SerializedName("page") val page:String,
    @SerializedName("results") val results:List<MovieModel>,
    @SerializedName("total_pages") val total_pages:String,
    @SerializedName("total_results") val total_results:String
)