package com.tutorials.stars.ui.screenModels

import com.tutorials.stars.data.network.Cocktails
import io.reactivex.Observable

data class AnimalScreenModel(
    val id: Int,
    val type: Int,
    val name: String,
    val image: Int,
    val seenBreeds: Int,
    val sumBreeds:Int,
    val cocktails: String
)