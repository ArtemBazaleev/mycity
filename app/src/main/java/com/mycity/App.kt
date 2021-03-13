package com.mycity


import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {

    }
}