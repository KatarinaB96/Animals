package com.tutorials.stars.data.crudder

import com.tutorials.stars.data.room.AnimalWithBreeds
import io.reactivex.Completable
import io.reactivex.Observable

interface Crudder {
    fun getDataFromDao(): Observable<List<AnimalWithBreeds>>
    fun updateBreed(isSeen: Boolean, breedId: Int): Completable

    fun addBreedToDatabase():Completable
    fun addAnimalToDatabase(): Completable
}