package com.tutorials.stars.data.dbModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "breed_table",
    foreignKeys = [ForeignKey(
        entity = AnimalDbModel::class,
        parentColumns = arrayOf("idAnimal"),
        childColumns = arrayOf("idAnimal"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class AnimalBreedDbModel(

    @PrimaryKey(autoGenerate = true) val breedId: Int,
    @ColumnInfo(name = "idAnimal") val idAnimal: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: Int,
    @ColumnInfo(name = "fact") val fact: String,
    @ColumnInfo(name = "isSeen") val isSeen: Boolean
)

