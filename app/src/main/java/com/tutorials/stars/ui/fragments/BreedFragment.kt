package com.tutorials.stars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tutorials.stars.base.BaseFragment
import com.tutorials.stars.databinding.FragmentBreedBinding
import com.tutorials.stars.di.fragment.FragmentComponent
import com.tutorials.stars.router.Router
import com.tutorials.stars.ui.adapter.AnimalAdapter
import com.tutorials.stars.ui.adapter.BreedsAdapter
import com.tutorials.stars.ui.screenModels.BreedScreenModel
import com.tutorials.stars.ui.viewModel.AnimalWithBreedsViewModel
import javax.inject.Inject


//val idAnimal: Int
class BreedFragment() : BaseFragment() {
    private lateinit var binding: FragmentBreedBinding

    @Inject
    lateinit var animalWithBreedsViewModel: AnimalWithBreedsViewModel

    companion object {
        private const val ID_ANIMAL = "idAnimal"
        private const val ID_BREED = "breedId"


        fun createInstance(idAnimal: Int) =
            BreedFragment().apply {
                arguments = Bundle().apply {
                    putInt(ID_ANIMAL, idAnimal)
//                    putInt(ID_BREED, breedId)

                }
            }
    }
//


    private var breedsAdapter: BreedsAdapter? = null

    @Inject
    lateinit var router: Router
    private val idAnimal: Int by lazy { arguments?.getInt(BreedFragment.ID_ANIMAL) ?: 0 }

    override fun inject(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBreedBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        animalWithBreedsViewModel.getBreeds(idAnimal)

        initAdapter()
        observeData()
    }

    private fun onItemClicked(breed: BreedScreenModel) {
        animalWithBreedsViewModel.updateBreed(breed.isSeen, breed.id)
        router.showDetailsFragment(breed.id, breed.image, breed.fact, breed.name, breed.isSeen)
    }



    private fun initAdapter() {

        breedsAdapter = BreedsAdapter { onItemClicked(it) }
        val idBreed = arguments?.getInt("breedId")


        binding.breedsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.breedsRecyclerView.adapter = breedsAdapter
    }

    private fun observeData() {
        animalWithBreedsViewModel.breeds.observe(viewLifecycleOwner) {
            breedsAdapter?.submitList(it.breeds)
        }
    }

}