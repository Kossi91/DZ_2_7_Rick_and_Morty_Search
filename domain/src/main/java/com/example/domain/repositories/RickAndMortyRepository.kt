package com.example.domain.repositories

import com.example.domain.models.Characters
import com.example.domain.models.RickAndMortyResponse
import com.example.domain.either.Either
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun searchCharacterName(name: String): Flow<Either<String, RickAndMortyResponse<Characters>>>

}