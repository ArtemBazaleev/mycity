package com.mycity.di

import com.mycity.presintation.module.map.ui.viewModel.MapViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    RepositoryModule::class,
    ApiModule::class
])
interface ApplicationComponent {
    fun inject(mapViewModel: MapViewModel)
}