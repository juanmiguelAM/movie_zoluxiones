package com.mancajima.movie_zoluxiones.domain.usescase

import com.mancajima.movie_zoluxiones.data.repository.UserRepository
import com.mancajima.movie_zoluxiones.data.database.entities.UserEntity
import com.mancajima.movie_zoluxiones.domain.model.User
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val userRepository: UserRepository){
    suspend fun insertUser(user:String, password:String, name:String){
        userRepository.insertUser(UserEntity(user, password, name))
    }

    suspend fun getUserLogin(user:String, password:String):List<User>{
        val users = userRepository.getLoginUser(user, password)
        return users
    }
}