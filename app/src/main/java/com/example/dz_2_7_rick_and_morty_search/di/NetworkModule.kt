package com.example.dz_2_7_rick_and_morty_search.di

import com.example.dz_2_7_rick_and_morty_search.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Provides
    @Singleton
    fun provideRickAndMortyApiService(retrofitClient: RetrofitClient) = retrofitClient.rickAndMortyApiService()
}