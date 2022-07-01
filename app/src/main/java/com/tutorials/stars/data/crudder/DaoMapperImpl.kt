package com.tutorials.stars.data.crudder

import com.tutorials.stars.data.network.CocktailClient
import com.tutorials.stars.data.network.Cocktails
import com.tutorials.stars.data.room.AnimalDao
import com.tutorials.stars.data.room.AnimalWithBreeds
import com.tutorials.stars.data.room.Breed
import io.reactivex.Observable


class DaoMapperImpl() : DaoMapper {

    override fun mapDataFromDao(
        animalDao: AnimalDao
    ): Observable<List<AnimalWithBreeds>> {
        return animalDao.getAnimalWithBreeds().map { it ->
            it.map {
                AnimalWithBreeds(
                    it.animal.idAnimal,
                    it.animal.type,
                    it.animal.breed,
                    it.animal.image,
                    it.breeds.map { Breed(it.breedId, it.name, it.image, it.fact, it.isSeen) }
                )
            }
        }
    }


}