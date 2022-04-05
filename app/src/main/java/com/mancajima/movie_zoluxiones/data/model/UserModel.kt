package com.mancajima.movie_zoluxiones.data.model

import com.google.gson.annotations.SerializedName

data class UserModel (
    @SerializedName("user") val user:String,
    @SerializedName("password") val password:String,
    @SerializedName("name") val name:String
)