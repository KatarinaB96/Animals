package com.tutorials.stars.ui.viewModel

import com.tutorials.stars.data.network.Cocktails
import com.tutorials.stars.data.room.AnimalWithBreeds
import com.tutorials.stars.ui.screenModels.AnimalScreenModel
import com.tutorials.stars.ui.screenModels.AnimalsScreenModel

interface AnimalsWithBreedsMapper {
    fun mapToScreenModel(it: List<AnimalWithBreeds>, cocktails: List<Cocktails?>): AnimalsScreenModel

}