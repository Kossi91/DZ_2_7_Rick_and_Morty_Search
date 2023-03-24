package com.example.dz_2_7_rick_and_morty_search.presentation.models

data class RickAndMortyResponseUI<D>(
    val results: List<D>,
    val info: InfoUI
)
