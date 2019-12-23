package com.treefintech.jetpack.bean

/*
*   Created by zhangping on 2019-12-20
*
*/
sealed class LoadState(val msg: String) {
    class Loading(msg: String = "") : LoadState(msg)
    class Success(msg: String = "") : LoadState(msg)
    class Fail(msg: String) : LoadState(msg)
}