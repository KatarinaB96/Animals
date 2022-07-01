package com.tutorials.stars.data.dbModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animalTable")
data class AnimalDbModel(
    @PrimaryKey
    val idAnimal: Int,
    @ColumnInfo(name = "breedType") val type: Int,
    @ColumnInfo(name = "breed") val breed: String,
    @ColumnInfo(name = "image") val image: Int
)
