package com.tutorials.stars.ui.viewModel

import androidx.lifecycle.MutableLiveData
import com.tutorials.stars.ui.screenModels.AnimalsScreenModel
import com.tutorials.stars.ui.screenModels.BreedsScreenModel

interface AnimalWithBreedsViewModel {
    val animals: MutableLiveData<AnimalsScreenModel>
    val breeds: MutableLiveData<BreedsScreenModel>

    fun updateBreed(isSeen: Boolean, breedId: Int)

    fun getBreeds(idAnimal: Int)


    fun getAnimals()

//    fun getBreedsIsSeen(idAnimal: Int):Int
//fun getAllBreedsIsSeen(idAnimal: Int): Int

//    fun getCount(idAnimal: Int)
}