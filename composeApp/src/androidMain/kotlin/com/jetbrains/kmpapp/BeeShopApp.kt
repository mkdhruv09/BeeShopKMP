package com.jetbrains.kmpapp

import android.app.Application
import com.jetbrains.kmpapp.di.initKoin

class BeeShopApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
