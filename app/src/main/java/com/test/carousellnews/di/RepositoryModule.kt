package com.test.carousellnews.di

import com.test.carousellnews.data.datasource.CarousellService
import com.test.carousellnews.data.repository.NewsRepository
import com.test.carousellnews.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by glenntuyu on 26/06/2024.
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    internal fun provideRepository(
        carousellService: CarousellService,
    ): NewsRepository {
        return NewsRepositoryImpl(carousellService)
    }
}