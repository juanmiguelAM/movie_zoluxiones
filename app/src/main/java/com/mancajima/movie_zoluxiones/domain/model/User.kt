package com.mancajima.movie_zoluxiones.domain.model

import com.mancajima.movie_zoluxiones.data.database.entities.UserEntity

data class User(val user:String, val password:String, val name:String)

fun UserEntity.toDomain() = User(user, password, name)