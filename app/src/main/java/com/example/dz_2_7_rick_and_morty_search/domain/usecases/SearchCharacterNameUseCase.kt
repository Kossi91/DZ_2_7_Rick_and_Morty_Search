package com.example.dz_2_7_rick_and_morty_search.domain.usecases

import com.example.dz_2_7_rick_and_morty_search.domain.either.Either
import com.example.dz_2_7_rick_and_morty_search.domain.models.Characters
import com.example.dz_2_7_rick_and_morty_search.domain.models.RickAndMortyResponse
import com.example.dz_2_7_rick_and_morty_search.domain.repositories.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchCharacterNameUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {

    operator fun invoke(name : String) : Flow<Either<String, RickAndMortyResponse<Characters>>> {
        return repository.searchCharacterName(name)
    }
}