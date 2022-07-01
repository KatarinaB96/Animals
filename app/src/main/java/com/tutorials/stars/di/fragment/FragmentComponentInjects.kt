package com.tutorials.stars.di.fragment

import com.tutorials.stars.ui.fragments.AnimalFragment
import com.tutorials.stars.ui.fragments.BreedFragment
import com.tutorials.stars.ui.fragments.DetailsFragment
import com.tutorials.stars.ui.fragments.WebFragment


interface FragmentComponentInjects {
    fun inject(fragment: AnimalFragment)
    fun inject(fragment: BreedFragment)
    fun inject(fragment: DetailsFragment)

    fun inject(fragment: WebFragment)
}