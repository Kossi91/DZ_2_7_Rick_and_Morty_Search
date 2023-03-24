package com.example.dz_2_7_rick_and_morty_search.di

import com.example.dz_2_7_rick_and_morty_search.data.repositories.RickAndMortyRepositoryImpl
import com.example.dz_2_7_rick_and_morty_search.domain.repositories.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindRickAndMortyRepository(repositoryImpl: RickAndMortyRepositoryImpl): RickAndMortyRepository
}