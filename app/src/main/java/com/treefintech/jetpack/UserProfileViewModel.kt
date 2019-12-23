package com.treefintech.jetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

/*
*   Created by zhangping on 2019-12-19
*
*/
class UserProfileViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    lateinit var user: LiveData<User>

    val userId : String = savedStateHandle["uid"] ?: throw IllegalArgumentException("missing user id")

    fun getData() {
        viewModelScope.launch(context = CoroutineExceptionHandler { _, e ->
            //加载失败的状态
//            loadState.value = LoadState.Fail(e.message ?: "加载失败")
        }) {
            //更新加载状态
//            loadState.value = LoadState.Loading()
//
//            //并发请求三张图片的数据
//            val data1 = async { NetworkService.apiService.getImage() }
//            val data2 = async { NetworkService.apiService.getImage() }
//            val data3 = async { NetworkService.apiService.getImage() }
//            //通过为LiveData设置新的值来触发更新UI
//            imageData.value = listOf(data1.await(), data2.await(), data3.await()).map {
//                it.imgurl
//            }
//
//            //更新加载状态
//            loadState.value = LoadState.Success()
        }
    }

}