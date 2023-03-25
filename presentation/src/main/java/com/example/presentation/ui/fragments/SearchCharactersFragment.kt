package com.example.presentation.ui.fragments

import android.util.Log
import android.widget.SearchView.OnQueryTextListener
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.base.BaseFragment
import com.example.presentation.R
import com.example.presentation.databinding.FragmentSearchCharactersBinding
import com.example.presentation.ui.adapters.CharacterAdapter
import com.example.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchCharactersFragment :
    BaseFragment<FragmentSearchCharactersBinding, SearchCharactersViewModel>(
        R.layout.fragment_search_characters
    ) {
    override val binding by viewBinding(FragmentSearchCharactersBinding::bind)
    override val viewModel: SearchCharactersViewModel by viewModels()
    private val adapter = CharacterAdapter()

    override fun initialize() {
        binding.rvRickAndMorty.adapter = adapter
    }

    override fun setupListeners() {
        binding.search.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.setCharacterName(it)
                }
                return false
            }
        })
        binding.btmFilter.setOnClickListener {
            findNavController().navigate(R.id.action_searchCharactersFragment_to_charactersFilterFragment)
        }
    }

    override fun setupSubscribes() {
        collectState()
    }

    private fun collectState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.characterState.collect {
                    when (it) {
                        is UIState.Error -> {
                            Log.e("ERROR", it.error)
                            binding.progressBar.isVisible = false
                        }
                        is UIState.Loading -> {
                            binding.progressBar.isVisible = true
                        }
                        is UIState.Success -> {
                            binding.progressBar.isVisible = false
                            adapter.submitList(it.data.results)
                        }
                    }
                }
            }
        }
    }
}