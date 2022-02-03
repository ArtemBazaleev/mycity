package com.mycity.di

import android.content.Context
import com.mycity.App
import com.mycity.di.actsubcomponent.ActivitySubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: App) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideApp(): App = application

}