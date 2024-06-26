package com.test.carousellnews.di

import com.test.carousellnews.data.datasource.CarousellService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by glenntuyu on 26/06/2024.
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideDataSource(): CarousellService = CarousellService.create()
}