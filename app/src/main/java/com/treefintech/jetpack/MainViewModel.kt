package com.treefintech.jetpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.treefintech.jetpack.bean.LoadState
import com.treefintech.jetpack.network.NetworkService
import kotlinx.coroutines.async

/*
*   Created by zhangping on 2019-12-20
*
*/
class MainViewModel : ViewModel() {
    val imageData = MutableLiveData<List<String>>()

    val loadState = MutableLiveData<LoadState>()
//    val user: LiveData<User> = liveData {
////        val data = database.loadUser() // loadUser is a suspend function.
////        emit(data)
//    }

    fun getData() {
        launch({
            loadState.value = LoadState.Loading("加载中...")
            val resultImage1 = async { NetworkService.apiService.getImage() }
            val resultImage2 = async { NetworkService.apiService.getImage() }
            val resultImage3 = async { NetworkService.apiService.getImage() }
            imageData.value =
                listOf(resultImage1.await(), resultImage3.await(), resultImage2.await()).map {
                    it.imgurl
                }
        }, {
            loadState.value = LoadState.Fail(it.message ?: "加载失败")
        }, {
            loadState.value = LoadState.Success()
        })
//        viewModelScope.launch (CoroutineExceptionHandler { coroutineContext, throwable ->
//            loadState.value = LoadState.Fail(throwable.message?:"加载失败")
//        }){
//            loadState.value = LoadState.Loading("加载中...")
//            val resultImage1 = async { NetworkService.apiService.getImage() }
//            val resultImage2 = async { NetworkService.apiService.getImage() }
//            val resultImage3 = async { NetworkService.apiService.getImage() }
//            imageData.value =
//                listOf(resultImage1.await(), resultImage3.await(), resultImage2.await()).map {
//                    it.imgurl
//                }
//            loadState.value = LoadState.Success()
//        }
    }

}