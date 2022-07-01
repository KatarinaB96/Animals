package com.tutorials.stars.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tutorials.stars.databinding.BreedItemBinding
import com.tutorials.stars.ui.screenModels.BreedScreenModel

class BreedsAdapter(
    val clickListener: (animal: BreedScreenModel) -> (Unit)

) :


    ListAdapter<BreedScreenModel, BreedsAdapter.BreedViewHolder>(BreedsListItemDiffUtilCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder(
            BreedItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    inner class BreedViewHolder(private val binding: BreedItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setItem(breed: BreedScreenModel) {
            binding.breedName.text = breed.name
            binding.breedImage.setImageResource(breed.image)

            if (breed.isSeen) binding.check.visibility = View.VISIBLE else binding.check.visibility = View.GONE
//            binding.check.visibility = breed.isSeen

//            breed.copy(isSeen = breed.isSeen)

//            binding.checkbox.setOnCheckedChangeListener { _, isChekcked ->
//                checkBox(breed.copy(isSeen = isChekcked))
//            }
        }
    }


    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val breedScreenModel = getItem(position)
        holder.itemView.setOnClickListener {

            clickListener(breedScreenModel.copy(isSeen = true))

            FragmentNavigatorExtras(it to "image_big")
        }
        holder.setItem(getItem(position))
    }

    class BreedsListItemDiffUtilCallback : DiffUtil.ItemCallback<BreedScreenModel>() {
        override fun areItemsTheSame(
            oldItem: BreedScreenModel,
            newItem: BreedScreenModel
        ): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(
            oldItem: BreedScreenModel,
            newItem: BreedScreenModel
        ): Boolean =
            true
    }


}