package com.example.domain.usecases

import com.example.domain.either.Either
import com.example.domain.models.Characters
import com.example.domain.models.RickAndMortyResponse
import com.example.domain.repositories.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchCharacterNameUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {

    operator fun invoke(name : String) : Flow<Either<String, RickAndMortyResponse<Characters>>> {
        return repository.searchCharacterName(name)
    }
}