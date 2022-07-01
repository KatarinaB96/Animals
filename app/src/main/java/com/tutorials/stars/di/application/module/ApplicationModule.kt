package com.tutorials.stars.di.application.module

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tutorials.stars.DeviceSharedPreferences
import com.tutorials.stars.DeviceSharedPreferencesImpl
import com.tutorials.stars.base.TemplateApplication
import com.tutorials.stars.data.room.AnimalDao
import com.tutorials.stars.data.room.AnimalDatabase
import com.tutorials.stars.data.crudder.Crudder
import com.tutorials.stars.data.crudder.CrudderImpl
import com.tutorials.stars.data.crudder.DaoMapper
import com.tutorials.stars.data.network.CocktailClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationModule(private val templateApplication: TemplateApplication) {

    @Provides
    @Singleton
    internal fun provideTemplateApplication(): TemplateApplication {
        return templateApplication
    }

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return templateApplication
    }

    @Provides
    @Singleton
    internal fun provideDao(animalDatabase: AnimalDatabase): AnimalDao {
        return animalDatabase.animalDao()
    }

    @Provides
    @Singleton
    internal fun provideCrudder(animalDao: AnimalDao, daoMapper: DaoMapper, client: CocktailClient): Crudder {
        return CrudderImpl(animalDao,daoMapper,client)
    }

//    @Provides
//    @Singleton
//    internal fun provideDaoBreed(animalDatabase: AnimalDatabase): AnimalBreedDao {
//        return animalDatabase.animalBreedDao()
//    }

    @Provides
    @Singleton
    internal fun provideDatabase(context: Context): AnimalDatabase {
        val MIGRATION_2_3 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE breed_table ADD COLUMN isSeen INTEGER DEFAULT 0 not null")
            }
        }
        return Room.databaseBuilder(
            context,
            AnimalDatabase::class.java, "animalDatabase"

        ).addMigrations(MIGRATION_2_3)
            .build()
    }


    @Provides
    @Singleton
    internal fun sharedPreferences(context: Context): DeviceSharedPreferences {
        return DeviceSharedPreferencesImpl(context)
    }


    interface Exposes {
        fun templateApplication(): TemplateApplication

        fun context(): Context
        fun preferences(): DeviceSharedPreferences

        fun room(): AnimalDatabase

        fun crudder(): Crudder
    }
}