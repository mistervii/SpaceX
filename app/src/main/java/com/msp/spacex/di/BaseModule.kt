package com.msp.spacex.di

import android.app.Application
import android.content.Context
import com.msp.spacex.data.repository.implementation.CompanyInfoRepositriyImpl
import com.msp.spacex.data.repository.implementation.LaunchesRepositoryImpl
import com.msp.spacex.data.repository.interfaces.CompanyInfoRepository
import com.msp.spacex.data.repository.interfaces.LaunchesRepository
import com.msp.spacex.data.usecase.CompanyInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BaseModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideCompanyInfoRepo() : CompanyInfoRepository {
        return CompanyInfoRepositriyImpl()
    }

    @Singleton
    @Provides
    fun provideLaunchesRepo() : LaunchesRepository{
        return LaunchesRepositoryImpl()
    }

}