package com.example.dz_2_7_rick_and_morty_search.data.remote.dtos

import com.example.dz_2_7_rick_and_morty_search.domain.models.Origin
import com.google.gson.annotations.SerializedName

data class OriginDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

fun OriginDto.toDomain(): Origin{
    return Origin(
        name,
        url
    )
}