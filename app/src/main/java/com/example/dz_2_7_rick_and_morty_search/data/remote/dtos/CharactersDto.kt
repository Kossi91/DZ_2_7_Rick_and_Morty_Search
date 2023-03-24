package com.example.dz_2_7_rick_and_morty_search.data.remote.dtos

import com.example.dz_2_7_rick_and_morty_search.domain.models.Characters
import com.google.gson.annotations.SerializedName

data class CharactersDto(
    @SerializedName("image") val image: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("species") val species: String,
    @SerializedName("created") val created: String,
    @SerializedName("origin") val origin: OriginDto,
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: LocationDto,
    @SerializedName("episode") val episode: List<String>?,
    @SerializedName("id") val id: Int = 0,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String,
    @SerializedName("status") val status: String
)

fun CharactersDto.toDomain(): Characters {
    return Characters(
        image,
        gender,
        species,
        created,
        origin.toDomain(),
        name,
        location.toDomain(),
        episode,
        id,
        type,
        url,
        status
    )
}