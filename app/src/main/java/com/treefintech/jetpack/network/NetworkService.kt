package com.treefintech.jetpack.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/*
*   Created by zhangping on 2019-12-20
*
*/
object NetworkService {
    //retorfit实例，在这里做一些统一网络配置，如添加转换器、设置超时时间等
    private val retrofit = Retrofit.Builder()
        .client(OkHttpClient.Builder().callTimeout(5, TimeUnit.SECONDS).build())
        .baseUrl("https://api.ooopn.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //网络层访问服务
    val apiService = retrofit.create(ApiService::class.java)
}