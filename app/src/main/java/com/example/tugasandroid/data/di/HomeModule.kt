package com.example.tugasandroid.data.di

import com.example.tugasandroid.data.remote.HomeRemoteDataSource
import com.example.tugasandroid.data.remote.HomeRemoteDataSourceImpl
import com.example.tugasandroid.data.repository.HomeRepository
import com.example.tugasandroid.data.repository.HomeRepositoryImpl
import com.example.tugasandroid.data.service.HomeRetrofit
import com.example.tugasandroid.data.service.HomeService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HomeModule {
    @Provides
    @Singleton
    fun provideRepository(homeRemoteDataSource: HomeRemoteDataSource): HomeRepository {
        return HomeRepositoryImpl(homeRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(homeService: HomeService): HomeRemoteDataSource {
        return HomeRemoteDataSourceImpl(homeService)
    }

    @Provides
    @Singleton
    fun provideHomeService(): HomeService {
        return HomeRetrofit.homeService
    }
}