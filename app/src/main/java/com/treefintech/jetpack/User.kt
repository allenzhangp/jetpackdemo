package com.treefintech.jetpack

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
*   Created by zhangping on 2019-12-19
*
*/
@Entity
data class User(
    @PrimaryKey val id: String,
    val name: String,
    val lastName: String
)