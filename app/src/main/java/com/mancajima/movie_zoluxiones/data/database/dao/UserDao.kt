package com.mancajima.movie_zoluxiones.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mancajima.movie_zoluxiones.data.database.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(userEntity: UserEntity)

    @Query("SELECT user, password, name FROM user_table WHERE user = :param1 AND password = :param2")
    fun getUser(param1:String, param2:String):List<UserEntity>
}