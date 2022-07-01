package com.tutorials.stars.data.crudder

import com.tutorials.stars.data.network.CocktailClient
import com.tutorials.stars.data.room.AnimalDao
import com.tutorials.stars.data.room.AnimalWithBreeds
import io.reactivex.Observable

interface DaoMapper {
    fun mapDataFromDao(animalDao: AnimalDao): Observable<List<AnimalWithBreeds>>
}