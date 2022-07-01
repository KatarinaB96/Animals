package com.tutorials.stars.router

import androidx.fragment.app.FragmentManager
import com.tutorials.stars.R
import com.tutorials.stars.ui.fragments.AnimalFragment
import com.tutorials.stars.ui.fragments.BreedFragment
import com.tutorials.stars.ui.fragments.DetailsFragment.Companion.createInstance
import com.tutorials.stars.ui.fragments.WebFragment


class RouterImpl(private val fragmentManager: FragmentManager) : Router {

    override fun showAnimalFragment() {

        val fragmentAnimals = AnimalFragment()

        fragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragmentAnimals)
            commit()
        }
    }

    override fun routerPopBack() {
        fragmentManager.popBackStack()
    }

    override fun showBreedsFragment(idAnimal: Int) {

        fragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, BreedFragment.createInstance(idAnimal))
            setReorderingAllowed(true)
            addToBackStack(null)
            commit()
        }
    }

    override fun showDetailsFragment(
        idBreed: Int,
        image: Int,
        fact: String,
        name: String,
        isSeen: Boolean
    ) {

        fragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, createInstance(idBreed,image,fact, name, isSeen))
            setReorderingAllowed(true)
            addToBackStack(null)
            setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
            commit()
        }
    }

    override fun showWebFragment() {
        val fragmentWeb = WebFragment()
        fragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragmentWeb)
            setReorderingAllowed(true)
            addToBackStack(null)
            setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
            commit()
        }
    }


}