package com.example.dz_2_7_rick_and_morty_search.domain.repositories


import com.example.dz_2_7_rick_and_morty_search.domain.models.Characters
import com.example.dz_2_7_rick_and_morty_search.domain.models.RickAndMortyResponse
import com.example.dz_2_7_rick_and_morty_search.domain.either.Either
import kotlinx.coroutines.flow.Flow


interface RickAndMortyRepository {

    fun searchCharacterName(name: String): Flow<Either<String, RickAndMortyResponse<Characters>>>

}