package com.treefintech.jetpack.network

import com.treefintech.jetpack.bean.ImageDataResponseBody
import com.treefintech.jetpack.bean.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

/*
*   Created by zhangping on 2019-12-20
*
*/
interface ApiService {
    //声明为suspend方法
    @GET("image/sogou/api.php")
    suspend fun getImage(@Query("type") type: String = "json"): ImageDataResponseBody

    @GET("image/sogou/api.php")
    suspend fun getImageNew(@Query("type") type: String = "json"): ResponseBody<ImageDataResponseBody>

}