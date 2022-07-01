package com.tutorials.stars


interface DeviceSharedPreferences {

    fun isDatabaseEmpty(): Boolean

    fun setDatabaseNotEmpty()

    fun isBreedSeen():Boolean

    fun setBreedSeen()


}