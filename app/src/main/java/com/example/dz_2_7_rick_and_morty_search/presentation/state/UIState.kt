package com.example.dz_2_7_rick_and_morty_search.presentation.state

sealed class UIState<T> {
    class Loading<T> : UIState<T>()
    class Error<T>(val error: String) : UIState<T>()
    class Success<T>(val data: T) : UIState<T>()
}