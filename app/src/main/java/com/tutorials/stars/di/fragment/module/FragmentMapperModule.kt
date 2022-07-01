package com.tutorials.stars.di.fragment.module

import com.tutorials.stars.ui.viewModel.AnimalsWithBreedsMapper
import com.tutorials.stars.ui.viewModel.AnimalsWithBreedsMapperImpl
import dagger.Module
import dagger.Provides

@Module
class FragmentMapperModule {

    @Provides
    fun provideAnimalsWithBreedMapper(): AnimalsWithBreedsMapper = AnimalsWithBreedsMapperImpl()

    interface Exposes {
        fun animalsWithBreedsMapper(): AnimalsWithBreedsMapper
    }
}