package com.tutorials.stars.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tutorials.stars.data.network.Cocktails
import com.tutorials.stars.data.room.AnimalWithBreeds
import com.tutorials.stars.domain.repository.AnimalRepository
import com.tutorials.stars.ui.screenModels.AnimalsScreenModel
import com.tutorials.stars.ui.screenModels.BreedScreenModel
import com.tutorials.stars.ui.screenModels.BreedsScreenModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers

class AnimalWithBreedsViewModelImpl(
    private val repository: AnimalRepository,
    private val mapper: AnimalsWithBreedsMapper
) :
    AnimalWithBreedsViewModel, ViewModel() {

    override val animals: MutableLiveData<AnimalsScreenModel> = MutableLiveData()
    override val breeds: MutableLiveData<BreedsScreenModel> = MutableLiveData()


    val list: MutableList<AnimalWithBreeds> = mutableListOf()


    private fun getList() {
        CompositeDisposable(
            Observables.zip(
                repository.getAnimalAndBreeds(),
                repository.getCocktaisList()
            )
                .doOnEach {
                    if (it.isOnComplete || it.isOnNext) {
                        list.addAll(it.value?.first?.toMutableList() ?: emptyList())
                    }
                }.map {
                    mapper.mapToScreenModel(it.first, it.second)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

                .subscribe({ onGetAnimalsSuccess(it) }, { it.printStackTrace() })
        )
    }


    override fun getAnimals() {
        getList()
    }

    private fun onGetAnimalsSuccess(animalsScreenModel: AnimalsScreenModel) {
        animals.postValue(animalsScreenModel)
    }

//    private fun onGetBreedsSuccess(breedScreenModel: BreedsScreenModel) {
//        breeds.postValue(breedScreenModel)
//    }

    override fun getBreeds(idAnimal: Int) {

        list.filter { it.id == idAnimal }.map {
            breeds.postValue(
                BreedsScreenModel(it.breeds.map {
                    BreedScreenModel(
                        it.id,
                        it.name,
                        it.image,
                        it.fact,
                        it.isSeen
                    )
                })
            )
        }
    }

    override fun updateBreed(isSeen: Boolean, breedId: Int) {
        CompositeDisposable(
            repository.updateBreed(isSeen, breedId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ }, { it.printStackTrace() })
        )

    }

//    override fun getBreedsIsSeen(idAnimal: Int): Int {
//
//        return list.find { it.id == idAnimal }?.breeds?.filter { it.isSeen == true }?.size ?: 0
//    }
//
//    override fun getAllBreedsIsSeen(idAnimal: Int): Int {
//        return list.find { it.id == idAnimal }?.breeds?.size ?: 0
//    }
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe({ onGetAnimalsSuccess(it) }, { it.printStackTrace() })
//        )


//    override fun getAnimals() {
//        CompositeDisposable(
//            repository.getAnimals()
//                .map {
//                    AnimalsScreenModel(it.map {
//                        AnimalScreenModel(
//                            it.id,
//                            it.type,
//                            it.name,
//                            it.image
//                        )
//                    })
//                }
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe({ onGetAnimalsSuccess(it) }, { it.printStackTrace() })
//        )
//    }


//    override fun getCount(idAnimal: Int) {
//        CompositeDisposable(
//            repository.countSeen(idAnimal)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe({ onGetCountsSuccess(it) }, { it.printStackTrace() })
//        )
//    }

//    private fun onGetCountsSuccess(breedsScreenModel: Int) {
//        counts.postValue(breedsScreenModel)
//    }


}