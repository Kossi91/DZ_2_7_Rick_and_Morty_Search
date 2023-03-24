package com.example.dz_2_7_rick_and_morty_search.data.remote.dtos

import com.example.dz_2_7_rick_and_morty_search.domain.models.Info
import com.google.gson.annotations.SerializedName

data class InfoDto(
    @SerializedName("next")
    val next: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev")
    val prev: String?,
    @SerializedName("count")
    val count: Int
)
fun InfoDto.toDomain():Info{
    return Info(
        next,
        pages,
        prev,
        count
    )
}