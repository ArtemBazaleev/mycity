package com.mycity.di

import com.mycity.presintation.module.map.data.provider.FakeApiGenerator
import com.mycity.presintation.module.map.data.provider.IMapDataProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideMapApi(): IMapDataProvider = FakeApiGenerator()

}