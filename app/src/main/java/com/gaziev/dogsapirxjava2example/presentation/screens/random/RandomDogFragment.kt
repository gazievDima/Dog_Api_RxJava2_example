package com.gaziev.dogsapirxjava2example.presentation.screens.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.gaziev.dogsapirxjava2example.App
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.FragmentRandomDogBinding
import com.gaziev.dogsapirxjava2example.presentation.screens.common.BaseFragment
import com.gaziev.dogsapirxjava2example.presentation.screens.common.ViewModelFactory
import javax.inject.Inject

class RandomDogFragment : BaseFragment<FragmentRandomDogBinding>() {
    override val title: String = "Random dog"
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRandomDogBinding =
        FragmentRandomDogBinding::inflate
    //private val viewModel: RandomDogViewModel by viewModels { ViewModelFactory(activity?.application!!) }

    @Inject
    lateinit var viewModel: RandomDogViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).daggerAppComponent.inject(this)

        viewModel.dogImage.observe(viewLifecycleOwner) { url: String? ->
            val res = url ?: R.drawable.failed_download
            setImage(res)
            binding.splash.visibility = View.GONE
        }

        binding.get.setOnClickListener {
            viewModel.getRandomDog()
        }
    }

    private fun setImage(url: Any) {
        Glide
            .with(this)
            .load(url)
            .placeholder(R.drawable.loading)
            .into(binding.dogContainer)
    }
}