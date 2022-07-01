package com.tutorials.stars

import android.content.Context
import android.content.SharedPreferences

class DeviceSharedPreferencesImpl(context: Context) : DeviceSharedPreferences {

    companion object {
        private const val SHARED_PREFS_FILE_NAME = "device_preferences"

        private const val DATABASE_EMPTY_KEY = "database_empty"

        private const val IS_SEEN = "breed_seen"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE)

    override fun isDatabaseEmpty(): Boolean = sharedPreferences.getBoolean(DATABASE_EMPTY_KEY, true)


    override fun setDatabaseNotEmpty() =
        sharedPreferences.edit()
            .putBoolean(DATABASE_EMPTY_KEY, false)
            .apply()

    override fun isBreedSeen(): Boolean = sharedPreferences.getBoolean(IS_SEEN, false)

    override fun setBreedSeen() {
        sharedPreferences.edit()
            .putBoolean(IS_SEEN, true)
            .apply()
    }

}