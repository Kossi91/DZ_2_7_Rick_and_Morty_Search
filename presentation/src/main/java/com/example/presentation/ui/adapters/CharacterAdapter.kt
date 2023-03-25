package com.example.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.domain.models.Characters
import com.example.presentation.databinding.ItemRickAndMortyBinding


class CharacterAdapter :
    ListAdapter<Characters, CharacterAdapter.CharacterViewHolder>(diffUtil) {

    inner class CharacterViewHolder(private val binding: ItemRickAndMortyBinding) :
        ViewHolder(binding.root) {

        fun onBind(item: Characters) {
            Glide.with(binding.itemCharacterImage.context)
                .load(item.image)
                .into(binding.itemCharacterImage)

            binding.itemCharacterStatus.text = item.status

            binding.itemCharacterGender.text = item.gender

            binding.itemCharacterName.text = item.name.replaceFirstChar {
                it.uppercase()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemRickAndMortyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Characters>() {
            override fun areItemsTheSame(oldItem: Characters, newItem: Characters): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Characters, newItem: Characters): Boolean {
                return oldItem == newItem
            }
        }
    }
}