package com.example.data.repositories

import com.example.data.remote.apiservices.RickAndMortyApiService
import com.example.data.remote.dtos.CharactersDto
import com.example.data.remote.dtos.Mapper
import com.example.data.remote.dtos.RickAndMortyResponseDto
import com.example.data.remote.dtos.toDomain
import com.example.domain.either.Either
import com.example.domain.models.Characters
import com.example.domain.models.RickAndMortyResponse
import com.example.domain.repositories.RickAndMortyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RickAndMortyRepositoryImpl @Inject constructor(private val apiService: RickAndMortyApiService) :
    RickAndMortyRepository {

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