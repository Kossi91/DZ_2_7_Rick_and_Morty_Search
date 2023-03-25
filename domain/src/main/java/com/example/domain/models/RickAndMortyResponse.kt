package com.example.domain.models

data class RickAndMortyResponse<D>(
    val results: List<D>,
    val info: Info
)
