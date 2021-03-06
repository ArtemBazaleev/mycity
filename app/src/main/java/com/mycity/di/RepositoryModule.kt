package com.mycity.di

import com.mycity.presintation.module.map.data.repository.MapRepository
import com.mycity.presintation.module.map.data.repository.MapRepositoryImp
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun provideMapRepository(repositoryImp: MapRepositoryImp) : MapRepository

}