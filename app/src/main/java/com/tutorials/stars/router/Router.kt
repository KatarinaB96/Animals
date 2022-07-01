package com.tutorials.stars.router

interface Router {
    fun showAnimalFragment()
    fun routerPopBack()
    fun showBreedsFragment(idAnimal:Int)
    fun showDetailsFragment(idBreed: Int,image: Int, fact: String ,name: String, isSeen:Boolean)

    fun showWebFragment()
}