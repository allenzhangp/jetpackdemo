package com.treefintech.jetpack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/*
*   Created by zhangping on 2019-12-21
*
*/
fun ViewModel.launch(
    block: suspend CoroutineScope.() -> Unit,
    onError: (e: Throwable) -> Unit = {},
    onComplete: () -> Unit = {}
) {
    viewModelScope.launch(CoroutineExceptionHandler { coroutineContext, throwable ->
        onError(throwable)
    }) {
        try {
            block(this)
        } finally {
            onComplete()
        }

    }

}