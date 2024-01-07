package com.ulugbek.cryptoconverter.di

import com.ulugbek.cryptoconverter.data.ConverterAPI
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

}