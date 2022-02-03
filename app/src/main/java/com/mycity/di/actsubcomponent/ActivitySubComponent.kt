package com.mycity.di.actsubcomponent

import com.mycity.presintation.module.map.ui.MainActivity
import com.mycity.presintation.module.map.ui.fragment.GoogleMapFragment
import com.mycity.presintation.module.map.ui.fragment.TestFragment
import com.mycity.presintation.module.map.ui.viewModel.MapViewModel
import com.mycity.presintation.module.map.ui.viewModel.TestViewModel
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        ActivityModule::class,
        NavigationModule::class
    ]
)
interface ActivitySubComponent {

    fun inject(act: MainActivity)
    fun inject(googleMapFragment: GoogleMapFragment)
    fun inject(testViewModel: TestViewModel)
    fun inject(testFragment: TestFragment)
    fun inject(mapViewModel: MapViewModel)

    @Subcomponent.Builder
    interface Builder {

        fun setActivityModule(activityModule: ActivityModule) : Builder

        fun build() : ActivitySubComponent
    }
}