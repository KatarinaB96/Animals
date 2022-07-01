package com.tutorials.stars.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tutorials.stars.data.dbModel.AnimalBreedDbModel
import com.tutorials.stars.data.dbModel.AnimalDbModel
import com.tutorials.stars.data.room.AnimalDao

@Database(entities = [AnimalDbModel::class, AnimalBreedDbModel::class], version = 2)
abstract class AnimalDatabase : RoomDatabase() {


    abstract fun animalDao(): AnimalDao
}