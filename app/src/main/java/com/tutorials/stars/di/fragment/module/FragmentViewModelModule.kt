package com.tutorials.stars.di.fragment.module

import androidx.lifecycle.ViewModelProvider
import com.tutorials.stars.base.BaseActivity
import com.tutorials.stars.domain.repository.AnimalRepository
import com.tutorials.stars.ui.viewModel.*
import dagger.Module
import dagger.Provides

@Module
class FragmentViewModelModule(private val activity: BaseActivity) {

//    @Provides
//    internal fun provideViewModelAnimal(repository: AnimalRepository): AnimalViewModel {
//        return ViewModelProvider(fragment, ViewModelProviderFactory(AnimalViewModelImpl::class) {
//            AnimalViewModelImpl(repository)
//        })[AnimalViewModelImpl::class.java]
//    }

    @Provides
    internal fun provideViewModelAnimalWithBreeds(repository: AnimalRepository,mapper: AnimalsWithBreedsMapper): AnimalWithBreedsViewModel {
        return ViewModelProvider(activity, ViewModelProviderFactory(AnimalWithBreedsViewModelImpl::class) {
            AnimalWithBreedsViewModelImpl(repository,mapper)
        })[AnimalWithBreedsViewModelImpl::class.java]
    }

//    @Provides
//    internal fun provideViewModelBreeds(repository: AnimalRepository): BreedViewModel {
//        return ViewModelProvider(fragment, ViewModelProviderFactory(BreedViewModelImpl::class) {
//            BreedViewModelImpl(repository)
//        })[BreedViewModelImpl::class.java]
//    }


    interface Exposes {
        fun animalWithBreedsViewModel(): AnimalWithBreedsViewModel
    }

}