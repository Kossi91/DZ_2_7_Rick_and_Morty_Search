package com.example.dz_2_7_rick_and_morty_search.domain.models

data class RickAndMortyResponse<D>(
    val results: List<D>,
    val info: Info
)
