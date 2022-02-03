package com.mycity.di

import com.mycity.di.actsubcomponent.ActivitySubComponent
import com.mycity.presintation.module.map.ui.viewModel.MapViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        RepositoryModule::class,
        ApiModule::class,
        SubComponentsModule::class
    ]
)
interface ApplicationComponent {

    fun activitySubComponentBuilder(): ActivitySubComponent.Builder

    fun inject(mapViewModel: MapViewModel)
}