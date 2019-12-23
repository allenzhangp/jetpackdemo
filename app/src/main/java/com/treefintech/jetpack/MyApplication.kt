package com.treefintech.jetpack

import android.app.Application
import com.facebook.stetho.Stetho

/*
*   Created by zhangping on 2019-12-19
*
*/
class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
    }
}