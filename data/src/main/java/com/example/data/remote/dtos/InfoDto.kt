package com.example.data.remote.dtos

import com.example.domain.models.Info
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
fun InfoDto.toDomain(): Info {
    return Info(
        next,
        pages,
        prev,
        count
    )
}