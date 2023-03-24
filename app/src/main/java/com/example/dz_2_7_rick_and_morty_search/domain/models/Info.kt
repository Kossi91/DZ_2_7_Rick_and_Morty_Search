package com.example.dz_2_7_rick_and_morty_search.domain.models

data class Info(
    val next: String,
    val pages: Int,
    val prev: String?,
    val count: Int
)