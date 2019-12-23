package com.treefintech.jetpack

import androidx.room.Database
import androidx.room.RoomDatabase

/*
*   Created by zhangping on 2019-12-19
*
*/
@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}