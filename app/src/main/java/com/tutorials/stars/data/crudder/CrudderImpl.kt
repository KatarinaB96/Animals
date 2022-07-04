package com.tutorials.stars.data.crudder

import com.tutorials.stars.R
import com.tutorials.stars.data.room.AnimalDao
import com.tutorials.stars.data.room.AnimalWithBreeds
import com.tutorials.stars.data.dbModel.AnimalBreedDbModel
import com.tutorials.stars.data.dbModel.AnimalDbModel
import com.tutorials.stars.data.network.CocktailClient
import io.reactivex.Completable
import io.reactivex.Observable

class CrudderImpl(private val animalDao: AnimalDao, private val daoMapper: DaoMapper,private val client: CocktailClient) : Crudder {

    override fun getDataFromDao(): Observable<List<AnimalWithBreeds>> {
        return daoMapper.mapDataFromDao(animalDao)
    }

    override fun updateBreed(isSeen: Boolean, breedId: Int): Completable {
        return Completable.fromAction { animalDao.updateSeen(isSeen, breedId) }
    }

    override fun addAnimalToDatabase(): Completable {

        return Completable.fromAction {
            val listAnimal: MutableList<AnimalDbModel> = mutableListOf()

            listAnimal.add(AnimalDbModel(1, 1, "Cat", R.drawable.cat))
            listAnimal.add(AnimalDbModel(2, 2, "Pig", R.drawable.pig))
            listAnimal.add(AnimalDbModel(3, 3, "Snake", R.drawable.snake))
            listAnimal.add(AnimalDbModel(4, 4, "Dog", R.drawable.dog))
            listAnimal.add(AnimalDbModel(5, 5, "Spider", R.drawable.spidy))

            animalDao.addAnimal(listAnimal)
        }
    }

    override fun addBreedToDatabase(): Completable {
        return Completable.fromAction {
            val listAnimalBreed: MutableList<AnimalBreedDbModel> = mutableListOf()
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    1,
                    "Persian",
                    R.drawable.cat_persian,
                    "The first documented ancestors of Persian cats were imported into Italy from Persia around 1620",
                    false
                )
            )
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    1,
                    "Maine Coon",
                    R.drawable.cat,
                    " It is one of the oldest natural breeds in North America. The breed originated in the U.S. state of Maine, where it is the official state cat. ",
                    false
                )
            )
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    1,
                    "British Shorthair",
                    R.drawable.cat,
                    "The most familiar colour variant is the British Blue",
                    false
                )
            )
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    1,
                    "Ragdoll",
                    R.drawable.cat,
                    "Ragdolls were developed by American breeder Ann Baker in the 1960s.",
                    false
                )
            )
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    1,
                    "Scottish Fold",
                    R.drawable.cat,
                    "The Scottish Fold is a breed of domestic cat with a natural dominant gene mutation that affects cartilage throughout the body, causing the ears to fold",
                    false
                )
            )

            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    2,
                    "Vietnamese Pot-bellied",
                    R.drawable.cat_persian,
                    "The first documented ancestors of Persian cats were imported into Italy from Persia around 1620",
                    false
                )
            )
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    2,
                    "Maine Coon",
                    R.drawable.cat,
                    " It is one of the oldest natural breeds in North America. The breed originated in the U.S. state of Maine, where it is the official state cat. ",
                    false
                )
            )
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    2,
                    "British Shorthair",
                    R.drawable.cat,
                    "The most familiar colour variant is the British Blue",
                    false
                )
            )
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    2,
                    "Ragdoll",
                    R.drawable.cat,
                    "Ragdolls were developed by American breeder Ann Baker in the 1960s.",
                    false
                )
            )
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    2,
                    "Scottish Fold",
                    R.drawable.cat,
                    "The Scottish Fold is a breed of domestic cat with a natural dominant gene mutation that affects cartilage throughout the body, causing the ears to fold",
                    false
                )
            )

            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    3,
                    "Persian",
                    R.drawable.cat_persian,
                    "The first documented ancestors of Persian cats were imported into Italy from Persia around 1620",
                    false
                )
            )
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    3,
                    "Maine Coon",
                    R.drawable.cat,
                    " It is one of the oldest natural breeds in North America. The breed originated in the U.S. state of Maine, where it is the official state cat. ",
                    false
                )
            )
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    3,
                    "British Shorthair",
                    R.drawable.cat,
                    "The most familiar colour variant is the British Blue",
                    false
                )
            )
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    3,
                    "Ragdoll",
                    R.drawable.cat,
                    "Ragdolls were developed by American breeder Ann Baker in the 1960s.",
                    false
                )
            )
            listAnimalBreed.add(
                AnimalBreedDbModel(
                    0,
                    3,
                    "Scottish Fold",
                    R.drawable.cat,
                    "The Scottish Fold is a breed of domestic cat with a natural dominant gene mutation that affects cartilage throughout the body, causing the ears to fold",
                    false
                )
            )
            animalDao.addBreed(listAnimalBreed)
        }
    }

}