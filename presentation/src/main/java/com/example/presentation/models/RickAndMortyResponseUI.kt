package com.example.presentation.models

data class RickAndMortyResponseUI<D>(
    val results: List<D>,
    val info: InfoUI
)
