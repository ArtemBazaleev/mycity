package com.mycity.di

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides

@Module
class ActivityModule constructor(
    private val fragmentActivity: FragmentActivity
) {

    @Provides
    @ActivityScope
    fun provideFragmentManager() = fragmentActivity.supportFragmentManager

}