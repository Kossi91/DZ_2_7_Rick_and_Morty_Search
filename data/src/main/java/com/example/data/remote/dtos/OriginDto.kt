package com.example.data.remote.dtos

import com.example.domain.models.Origin
import com.google.gson.annotations.SerializedName

data class OriginDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

fun OriginDto.toDomain(): Origin {
    return Origin(
        name,
        url
    )
}