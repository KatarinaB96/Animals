package com.tutorials.stars.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tutorials.stars.domain.repository.AnimalRepository
import com.tutorials.stars.ui.screenModels.BreedScreenModel
import com.tutorials.stars.ui.screenModels.BreedsScreenModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BreedViewModelImpl(private val repository: AnimalRepository) :  ViewModel() {
//    override val breeds: MutableLiveData<BreedsScreenModel> = MutableLiveData()
//    override fun getBreeds(idAnimal: Int) {
//        TODO("Not yet implemented")
//    }
//
//
////    override fun getBreeds(idAnimal: Int) {
////        CompositeDisposable(
////            repository.getAnimalAndBreeds(idAnimal).map {
////                BreedsScreenModel(it.map {
////                    BreedScreenModel(
////                        it.id,
////                        it.name,
////                        it.image,
////                        it.fact,
////                        it.isSeen
////                    )
////                })
////            }
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribeOn(Schedulers.io())
////                .subscribe({ onGetAnimalsSuccess(it) }, { })
////        )
////    }
//
//    override fun updateBreed(isSeen: Boolean, breedId: Int) {
//        CompositeDisposable(
//            repository.updateBreed(isSeen, breedId)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe({ }, { it.printStackTrace() })
//        )
//
//    }
//
//
//
//    private fun onGetAnimalsSuccess(breedsScreenModel: BreedsScreenModel) {
//        breeds.postValue(breedsScreenModel)
//    }


}