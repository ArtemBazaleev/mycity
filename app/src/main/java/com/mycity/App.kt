package com.mycity

import android.app.Application
import com.mycity.di.actsubcomponent.ActivitySubComponent
import com.mycity.di.ApplicationComponent
import com.mycity.di.ApplicationModule
import com.mycity.di.DaggerApplicationComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        component = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object {
        lateinit var component: ApplicationComponent
        var actSubComponent: ActivitySubComponent? = null
    }
}