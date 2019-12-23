package com.treefintech.jetpack.bean

/*
*   Created by zhangping on 2019-12-21
*
*/
data class ResponseBody<T>(
    val code: Int,
    val msg: String,
    val data: T
)