package com.example.dz_2_7_rick_and_morty_search.presentation.ui.fragments

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.dz_2_7_rick_and_morty_search.presentation.base.BaseViewModel
import com.example.dz_2_7_rick_and_morty_search.domain.either.Either
import com.example.dz_2_7_rick_and_morty_search.domain.models.Characters
import com.example.dz_2_7_rick_and_morty_search.domain.models.RickAndMortyResponse
import com.example.dz_2_7_rick_and_morty_search.domain.usecases.SearchCharacterNameUseCase
import com.example.dz_2_7_rick_and_morty_search.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchCharactersViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val searchCharacterNameUseCase: SearchCharacterNameUseCase
) :
    BaseViewModel() {

    private val _characterState =
        MutableStateFlow<UIState<RickAndMortyResponse<Characters>>>(UIState.Loading())
    val characterState = _characterState.asStateFlow()

    private val searchResultData: StateFlow<String> =
        savedStateHandle.getStateFlow("name", "")

    private val filterStatusResultData: StateFlow<String> =
        savedStateHandle.getStateFlow("status", "")

    private val filterGenderResultData: StateFlow<String> =
        savedStateHandle.getStateFlow("gender", "")

    fun setCharacterName(name: String) {
        savedStateHandle["name"] = name
    }

    init {
        searchCharacterByName()
    }

    private fun searchCharacterByName() {
        viewModelScope.launch {
            searchResultData.flatMapLatest { name ->
                searchCharacterNameUseCase(name)
            }.collect { either ->
                when (either) {
                    is Either.Left -> {
                        either.massage?.let {
                            _characterState.value = UIState.Error(it)
                        }
                    }
                    is Either.Right -> {
                        either.data?.let {
                            _characterState.value = UIState.Success(it)
                        }
                    }
                }
            }
        }
    }
}

//    private fun filterCharacterByStatusAndGender() {
//        viewModelScope.launch {
//            filterStatusResultData.flatMapLatest { status ->
//                filterGenderResultData.flatMapLatest { gender ->
//                    repository.filterCharactersByStatusAndGender(status, gender)
//                }
//            }
//        }
//    }
