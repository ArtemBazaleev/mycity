package com.mycity.di

import com.mycity.di.actsubcomponent.ActivitySubComponent
import dagger.Module

@Module(subcomponents = [ActivitySubComponent::class])
class SubComponentsModule