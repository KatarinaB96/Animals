package com.tutorials.stars.data.room

data class AnimalWithBreeds(
    val id: Int,
    val type: Int,
    val name: String,
    val image: Int,
    val breeds: List<Breed>
)