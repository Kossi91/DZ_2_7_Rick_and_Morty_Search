package com.example.data.remote.apiservices

import com.example.data.remote.dtos.CharactersDto
import com.example.data.remote.dtos.RickAndMortyResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApiService {

    @GET("character")
    suspend fun searchCharacterName(
        @Query("name") name: String
    ): RickAndMortyResponseDto<CharactersDto>

    @GET("character")
    suspend fun filterCharactersByStatusAndGender(
        @Query("status") status: String,
        @Query("gender") gender: String
    ): RickAndMortyResponseDto<CharactersDto>

    @GET("character")
    suspend fun filterCharactersByStatus(
        @Query("status") status: String,
    ): RickAndMortyResponseDto<CharactersDto>

    @GET("character")
    suspend fun filterCharactersByGender(
        @Query("gender") gender : String
    ): RickAndMortyResponseDto<CharactersDto>
}