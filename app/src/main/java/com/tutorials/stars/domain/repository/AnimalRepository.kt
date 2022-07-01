package com.tutorials.stars.domain.repository

import com.tutorials.stars.data.network.Cocktails
import com.tutorials.stars.data.room.AnimalWithBreeds
import io.reactivex.Completable
import io.reactivex.Observable

interface AnimalRepository {
    fun addAnimalToDatabase(): Completable
    fun addBreedToDatabase(): Completable

    fun getCocktaisList(): Observable<List<Cocktails?>>

//    fun getAnimals(): Observable<List<Animal>>
//    fun getBreed(idAnimal: Int): Observable<List<Breed>>
     fun getAnimalAndBreeds():Observable< List<AnimalWithBreeds>>

    fun updateBreed(isSeen: Boolean, breedId: Int): Completable

//    fun countSeen(idAnimal: Int): Observable<Int>
}