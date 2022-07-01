package com.tutorials.stars.data.room

import androidx.room.*
import com.tutorials.stars.data.dbModel.AnimalBreedDbModel
import com.tutorials.stars.data.dbModel.AnimalDbModel
import com.tutorials.stars.data.dbModel.AnimalWithBreedsDbModel
import io.reactivex.Observable

@Dao
interface AnimalDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addBreed(animalBreedDbModel: List<AnimalBreedDbModel>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAnimal(animalDbModel: List<AnimalDbModel>)

    @Query("SELECT * FROM animalTable")
    fun getAnimal(): Observable<List<AnimalDbModel>>

    @Query("SELECT * FROM breed_table WHERE idAnimal = :idAnimal")
    fun getBreeds(idAnimal: Int): Observable<List<AnimalBreedDbModel>>

    @Query("UPDATE breed_table SET isSeen = :isSeen WHERE breedId = :breedId")
    fun updateSeen(isSeen: Boolean, breedId: Int)

    @Query("SELECT COUNT(*) FROM breed_table WHERE isSeen = 1 AND idAnimal = :animalId")
    fun countSeen(animalId: Int): Observable<Int>

    @Transaction
    @Query("SELECT * FROM animalTable")
    fun getAnimalWithBreeds(): Observable<List<AnimalWithBreedsDbModel>>
}