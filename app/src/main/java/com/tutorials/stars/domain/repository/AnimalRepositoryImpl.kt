package com.tutorials.stars.domain.repository

import com.tutorials.stars.DeviceSharedPreferences
import com.tutorials.stars.data.room.AnimalWithBreeds
import com.tutorials.stars.data.crudder.Crudder
import com.tutorials.stars.data.network.CocktailClient
import com.tutorials.stars.data.network.Cocktails
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AnimalRepositoryImpl(
    private val deviceSharedPreferences: DeviceSharedPreferences,
    private val crudder: Crudder,
    private val cocktailClient: CocktailClient
) : AnimalRepository {

    init {
        if (deviceSharedPreferences.isDatabaseEmpty()) {
            CompositeDisposable(
                addAnimalToDatabase()
                    .andThen(addBreedToDatabase())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        deviceSharedPreferences.setDatabaseNotEmpty()
                    }
            )
        }
    }

    override fun getCocktaisList(): Observable<List<Cocktails?>> {
        return cocktailClient.getCocktails()
    }

    override fun addAnimalToDatabase(): Completable {
        return crudder.addAnimalToDatabase()
    }

    override fun addBreedToDatabase(): Completable {
        return crudder.addBreedToDatabase()
    }

    override fun getAnimalAndBreeds(): Observable<List<AnimalWithBreeds>> {
        return crudder.getDataFromDao()
    }

    override fun updateBreed(isSeen: Boolean, breedId: Int): Completable {
        return crudder.updateBreed(isSeen, breedId)
    }
}


//    override fun getAnimals(): Observable<List<Animal>> {
//        return animalDao.getAnimal()
//            .map { it -> it.map { Animal(it.idAnimal, it.type, it.breed, it.image) } }
//    }

//    override fun getBreed(idAnimal: Int): Observable<List<Breed>> {
//        return animalDao.getBreeds(idAnimal)
//            .map { it -> it.map { Breed(it.breedId, it.name, it.image, it.fact, it.isSeen) } }
//    }


//    override fun countSeen(idAnimal: Int):Observable<List<Breed>> {
//        return animalDao.countSeen(idAnimal)
//            .map { it -> it.map { Breed(it.breedId, it.name, it.image, it.fact, it.isSeen) } }
//    }

//    override fun countSeen(idAnimal: Int): Observable<Int> {
//        return animalDao.countSeen(idAnimal)
//
