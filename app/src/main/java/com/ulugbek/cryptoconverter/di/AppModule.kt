package com.ulugbek.cryptoconverter.di

import com.ulugbek.cryptoconverter.data.ConverterAPI
import com.ulugbek.cryptoconverter.main.MainRepository
import com.ulugbek.cryptoconverter.main.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module

@InstallIn(SingletonComponent::class)
object AppModule{
    @Singleton
    @Provides
    fun getConverterApi():ConverterAPI{
        return Retrofit
            .Builder()
            .build()
            .create(ConverterAPI::class.java)
    }

    @Singleton
    @Provides
    fun getMainRepository(api: ConverterAPI):MainRepository=MainRepositoryImpl(api)

}