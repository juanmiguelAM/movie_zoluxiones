package com.mancajima.movie_zoluxiones.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity (
    @PrimaryKey @ColumnInfo(name = "user") val user:String,
    @ColumnInfo(name = "password") val password:String,
    @ColumnInfo(name = "name") val name:String
)

