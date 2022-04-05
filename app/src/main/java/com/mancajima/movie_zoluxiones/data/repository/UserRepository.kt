package com.mancajima.movie_zoluxiones.data.repository

import com.mancajima.movie_zoluxiones.data.database.dao.UserDao
import com.mancajima.movie_zoluxiones.data.database.entities.UserEntity
import com.mancajima.movie_zoluxiones.domain.model.User
import com.mancajima.movie_zoluxiones.domain.model.toDomain
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao){

    suspend fun insertUser(userEntity: UserEntity){
        userDao.insertUser(userEntity)
    }

    suspend fun getLoginUser(user:String, password:String):List<User>{
        val response:List<UserEntity> = userDao.getUser(user, password)
        return response.map { it.toDomain() }
    }

}