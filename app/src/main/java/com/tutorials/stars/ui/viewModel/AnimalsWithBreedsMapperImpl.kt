package com.tutorials.stars.ui.viewModel

import com.tutorials.stars.data.network.Cocktails
import com.tutorials.stars.data.room.AnimalWithBreeds
import com.tutorials.stars.ui.screenModels.AnimalScreenModel
import com.tutorials.stars.ui.screenModels.AnimalsScreenModel

class AnimalsWithBreedsMapperImpl : AnimalsWithBreedsMapper {



    override fun mapToScreenModel(
        it: List<AnimalWithBreeds>,
        cocktails: List<Cocktails?>
    ): AnimalsScreenModel {
        return AnimalsScreenModel(it.mapIndexed { index, animal  ->
            AnimalScreenModel(
                animal.id,
                animal.type,
                animal.name,
                animal.image,
                animal.breeds.count { it.isSeen },
                animal.breeds.size,
                cocktails.getOrNull(index)?.strGlass ?: ""
            )
        })
    }


}


