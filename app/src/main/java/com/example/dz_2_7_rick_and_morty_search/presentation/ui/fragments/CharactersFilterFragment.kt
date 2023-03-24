package com.example.dz_2_7_rick_and_morty_search.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dz_2_7_rick_and_morty_search.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CharactersFilterFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_filter, container, false)
    }
}