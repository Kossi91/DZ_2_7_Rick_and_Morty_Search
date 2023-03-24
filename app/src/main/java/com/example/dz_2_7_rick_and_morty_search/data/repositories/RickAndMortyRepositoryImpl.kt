package com.example.dz_2_7_rick_and_morty_search.data.repositories

import com.example.dz_2_7_rick_and_morty_search.data.remote.apiservices.RickAndMortyApiService
import com.example.dz_2_7_rick_and_morty_search.domain.either.Either
import com.example.dz_2_7_rick_and_morty_search.data.remote.dtos.CharactersDto
import com.example.dz_2_7_rick_and_morty_search.data.remote.dtos.Mapper
import com.example.dz_2_7_rick_and_morty_search.data.remote.dtos.RickAndMortyResponseDto
import com.example.dz_2_7_rick_and_morty_search.data.remote.dtos.toDomain
import com.example.dz_2_7_rick_and_morty_search.domain.models.Characters
import com.example.dz_2_7_rick_and_morty_search.domain.models.RickAndMortyResponse
import com.example.dz_2_7_rick_and_morty_search.domain.repositories.RickAndMortyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RickAndMortyRepositoryImpl @Inject constructor(private val apiService: RickAndMortyApiService) : RickAndMortyRepository {

    override fun searchCharacterName(name: String) = flow<Either<String, RickAndMortyResponse<Characters>>> {
        emit(Either.Right(apiService.searchCharacterName(name).toDomain(object :
            Mapper<CharactersDto, Characters> {
            override fun map(type: CharactersDto): Characters {
                return type.toDomain()
            }
        })))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage?: "Error Occurred" ))
    }

    fun filterCharactersByStatusAndGender(status:String, gender: String) = flow<Either<String, RickAndMortyResponseDto<CharactersDto>>>{
        emit(Either.Right(apiService.filterCharactersByStatusAndGender(status , gender)))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage?:"Error Occurred"))
    }

    fun filterCharactersByStatus(status: String) = flow<Either<String, RickAndMortyResponseDto<CharactersDto>>>{
        emit(Either.Right(apiService.filterCharactersByStatus(status)))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage?:"Error Occurred"))
    }
    fun filterCharactersByGender(gender: String) = flow<Either<String, RickAndMortyResponseDto<CharactersDto>>>{
        emit(Either.Right(apiService.filterCharactersByGender(gender)))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage?:"Error Occurred"))
    }
}