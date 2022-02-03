package com.mycity.di.actsubcomponent

import androidx.fragment.app.FragmentManager
import com.mycity.di.actsubcomponent.ActivityScope
import com.mycity.presintation.module.map.ui.navigation.NavigationController
import com.mycity.presintation.module.map.ui.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
class NavigationModule {

    @Provides
    @ActivityScope
    fun providesNavigator(fragmentManager: FragmentManager): Navigator =
        NavigationController(fragmentManager)
}