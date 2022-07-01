package com.tutorials.stars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.tutorials.stars.R
import com.tutorials.stars.base.BaseFragment
import com.tutorials.stars.databinding.WebBinding
import com.tutorials.stars.di.fragment.FragmentComponent
import com.tutorials.stars.router.Router
import com.tutorials.stars.ui.adapter.AnimalAdapter
import javax.inject.Inject


class WebFragment : BaseFragment() {
    private lateinit var binding: WebBinding
    private var animalAdapter: AnimalAdapter? = null



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
        binding = WebBinding.inflate(layoutInflater)

        val url = "https://developer.android.com/guide/webapps/webview"
        val view = binding.webview
        view.settings.javaScriptEnabled = true
        view.loadUrl(url)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }




}