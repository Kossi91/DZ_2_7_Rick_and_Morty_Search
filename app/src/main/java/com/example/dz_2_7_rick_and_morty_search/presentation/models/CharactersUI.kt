package com.example.dz_2_7_rick_and_morty_search.presentation.models


data class CharactersUI(
    val image: String,
    val gender: String,
    val species: String,
    val created: String,
    val origin: OriginUI,
    val name: String,
    val location: LocationUI,
    val episode: List<String>?,
    val id: Int = 0,
    val type: String,
    val url: String,
    val status: String
)