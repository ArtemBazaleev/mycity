package com.mycity.di.actsubcomponent

import androidx.fragment.app.FragmentActivity
import com.mycity.di.actsubcomponent.ActivityScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule constructor(
    private val fragmentActivity: FragmentActivity
) {

    @Provides
    @ActivityScope
    fun provideFragmentManager() = fragmentActivity.supportFragmentManager

}