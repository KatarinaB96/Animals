package com.tutorials.stars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tutorials.stars.base.BaseFragment
import com.tutorials.stars.databinding.FragmentAnimalBinding
import com.tutorials.stars.di.fragment.FragmentComponent
import com.tutorials.stars.router.Router
import com.tutorials.stars.ui.adapter.AnimalAdapter
import com.tutorials.stars.ui.screenModels.AnimalScreenModel
import com.tutorials.stars.ui.viewModel.AnimalWithBreedsViewModel
import javax.inject.Inject


class AnimalFragment : BaseFragment() {
    private lateinit var binding: FragmentAnimalBinding
    private var animalAdapter: AnimalAdapter? = null

    @Inject
    lateinit var animalWithBreedsViewModel: AnimalWithBreedsViewModel

    @Inject
    lateinit var router: Router

    override fun inject(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnimalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animalWithBreedsViewModel.getAnimals()
        initAdapter()
        observeData()
    }

    private fun onItemClicked(animal: AnimalScreenModel) {
        router.showBreedsFragment(animal.id)
    }


    private fun initAdapter() {
        animalAdapter = AnimalAdapter { onItemClicked(it) }

        binding.animalsRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.animalsRecycler.adapter = animalAdapter
    }

    private fun observeData() {
        animalWithBreedsViewModel.animals.observe(viewLifecycleOwner) {
            animalAdapter?.submitList(it.animals)
        }
    }

//    private fun getProgress() {
//        animalWithBreedsViewModel.counts.observe(viewLifecycleOwner) {
//            sumOfIsSeen = it
//        }
//    }

//    private fun getAll(idAnimal: Int): Int {
//        return breedViewModel.getBreeds(idAnimal)
//    }
}