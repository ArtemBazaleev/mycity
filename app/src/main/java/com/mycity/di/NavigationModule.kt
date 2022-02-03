package com.mycity.di

import androidx.fragment.app.FragmentManager
import com.mycity.presintation.module.map.ui.navigation.NavigationController
import com.mycity.presintation.module.map.ui.navigation.Navigator
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    @Provides
    @ActivityScope
    fun providesNavigator(fragmentManager: FragmentManager): Navigator =
        NavigationController(fragmentManager)
}