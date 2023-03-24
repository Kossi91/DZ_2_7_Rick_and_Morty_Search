package com.example.dz_2_7_rick_and_morty_search.data.remote.dtos

import com.example.dz_2_7_rick_and_morty_search.domain.models.RickAndMortyResponse
import com.google.gson.annotations.SerializedName

data class RickAndMortyResponseDto<T>(
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("info")
    val info: InfoDto
)

fun <T, D> RickAndMortyResponseDto<T>.toDomain(mapper: Mapper<T, D>): RickAndMortyResponse<D> {
    return RickAndMortyResponse(
        results.map {
            mapper.map(it)
        },
        info.toDomain()
    )
}

interface Mapper<T, D> {
    fun map(type: T): D
}