package com.tutorials.stars.ui.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tutorials.stars.R
import com.tutorials.stars.base.BaseFragment
import com.tutorials.stars.databinding.FragmentDetailsBinding
import com.tutorials.stars.di.fragment.FragmentComponent
import com.tutorials.stars.router.Router
import com.tutorials.stars.ui.viewModel.BreedViewModel
import javax.inject.Inject

//val idAnimal: Int, val image: Int, val fact: String, val name: String, val isSeen:Boolean
class DetailsFragment() : BaseFragment() {

    companion object {
        private const val ID_BREED = "breedId"
        private const val IMAGE_KEY = "image"

        private const val FACT = "fact"
        private const val NAME = "name"
        private const val IS_SEEN = "isSeen"


        fun createInstance(idBreed: Int, image: Int, fact: String, name: String, isSeen: Boolean) =
            DetailsFragment().apply {

                arguments = Bundle().apply {
                    putInt(ID_BREED, idBreed)
                    putInt(IMAGE_KEY, image)
                    putString(FACT, fact)
                    putString(NAME, name)
                    putBoolean(IS_SEEN, isSeen)
                }


            }

    }

    private lateinit var binding: FragmentDetailsBinding


    override fun inject(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

//    @Inject
//    lateinit var breedViewModel: BreedViewModel

    @Inject
    lateinit var router: Router

    private val idBreed: Int by lazy { arguments?.getInt(ID_BREED) ?: 0 }
    private val image: Int by lazy { arguments?.getInt(IMAGE_KEY) ?: 0 }
    private val fact: String by lazy { arguments?.getString(FACT) ?: "" }
    private val name: String by lazy { arguments?.getString(NAME) ?: "" }
    private val isSeen: Boolean by lazy { arguments?.getBoolean(IS_SEEN) ?: false }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_right)
        exitTransition = inflater.inflateTransition(R.transition.fade)

        binding = FragmentDetailsBinding.inflate(layoutInflater)

//        breedViewModel.updateBreed(isSeen, idBreed)

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val image = arguments?.getInt(IMAGE_KEY)
//        val fact = arguments?.getString("fact")
//        val name = arguments?.getString("name")

        binding.breedImage.setImageResource(image)
        binding.fact.text = fact
        binding.name.text = name


//        binding.breedImage.setOnClickListener {
//            router.showBreedsFragment(idAnimal)
//        }
    }


}