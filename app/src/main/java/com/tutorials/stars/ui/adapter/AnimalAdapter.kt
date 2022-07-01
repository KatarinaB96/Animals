package com.tutorials.stars.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tutorials.stars.databinding.AnimalItemBinding
import com.tutorials.stars.ui.screenModels.AnimalScreenModel

class AnimalAdapter(
    val clickListener: (animal: AnimalScreenModel) -> (Unit),
) :

    ListAdapter<AnimalScreenModel, AnimalAdapter.AnimalViewHolder>(AnimalsListItemDiffUtilCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(
            AnimalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    inner class AnimalViewHolder(private val binding: AnimalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setItem(animal: AnimalScreenModel) {
            binding.animalName.text = animal.name
            binding.imageOfAnimal.setImageResource(animal.image)

            binding.circularProgressbar.progress = animal.seenBreeds
            binding.circularProgressbar.max = animal.sumBreeds

            binding.cocktails.text = animal.cocktails

            binding.itemContainer.setOnClickListener {
                clickListener(animal)
            }
        }
    }


    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {

        holder.setItem(getItem(position))
    }

    class AnimalsListItemDiffUtilCallback : DiffUtil.ItemCallback<AnimalScreenModel>() {
        override fun areItemsTheSame(
            oldItem: AnimalScreenModel,
            newItem: AnimalScreenModel
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: AnimalScreenModel,
            newItem: AnimalScreenModel
        ): Boolean = oldItem == newItem
    }
}