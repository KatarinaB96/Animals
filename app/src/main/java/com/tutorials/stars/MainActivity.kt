package com.tutorials.stars

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toolbar
import android.widget.ViewAnimator
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.tutorials.stars.base.BaseActivity
import com.tutorials.stars.databinding.ActivityMainBinding
import com.tutorials.stars.di.activity.ActivityComponent
import com.tutorials.stars.router.Router
import com.tutorials.stars.ui.fragments.BreedFragment
import com.tutorials.stars.ui.fragments.DetailsFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var router: Router //za prikaz fragmenta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        router.showAnimalFragment()

        binding.myToolbar.navigationIcon = null
        binding.myToolbar.title = "animals"

        supportFragmentManager.addOnBackStackChangedListener {
            Log.e("log", supportFragmentManager.fragments.last().javaClass.simpleName)
            when (supportFragmentManager.findFragmentById(R.id.fragmentContainerView)) {
                is DetailsFragment -> {
                    binding.myToolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_new_24)
                    binding.myToolbar.title = "Details"
                    binding.myToolbar.setOnClickListener {
                        router.routerPopBack()
                    }
                }
                is BreedFragment -> {
                    binding.myToolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_new_24)
                    binding.myToolbar.title = "Breeds"
                    binding.myToolbar.setOnClickListener {
                        router.routerPopBack()
                    }
                }
                else -> {
                    binding.myToolbar.navigationIcon = null
                    binding.myToolbar.title = "Animals"
                }
            }
        }


//        binding.webButton.setOnClickListener {
//            router.showWebFragment()
//
//        }
    }


    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}