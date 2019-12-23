package com.treefintech.jetpack.network

import com.treefintech.jetpack.bean.ImageDataResponseBody
import com.treefintech.jetpack.bean.ResponseBody


/*
*   Created by zhangping on 2019-12-21
*
*/
class Repository {
    private fun <T> preprocessData(response: ResponseBody<T>): T =
        if (response.code == 200) response.data else throw Throwable(response.msg)

    suspend fun getImageData(): ImageDataResponseBody {
        val result = NetworkService.apiService.getImageNew()
        return preprocessData(result)
    }
}