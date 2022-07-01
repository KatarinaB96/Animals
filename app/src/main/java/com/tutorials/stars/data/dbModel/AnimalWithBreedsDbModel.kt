package com.tutorials.stars.data.dbModel

import androidx.room.Embedded
import androidx.room.Relation

data class AnimalWithBreedsDbModel (
    @Embedded
    val animal: AnimalDbModel,
    @Relation(
        parentColumn = "idAnimal",
        entityColumn = "idAnimal"
    )
    val breeds: List<AnimalBreedDbModel>
    )