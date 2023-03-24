package com.example.dz_2_7_rick_and_morty_search.data.remote.dtos

import com.example.dz_2_7_rick_and_morty_search.domain.models.Location
import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

fun LocationDto.toDomain() : Location {
    return Location(
        name,
        url
    )
}