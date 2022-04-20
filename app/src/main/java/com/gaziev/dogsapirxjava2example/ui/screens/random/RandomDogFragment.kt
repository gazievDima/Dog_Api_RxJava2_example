package com.gaziev.dogsapirxjava2example.ui.screens.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.FragmentRandomDogBinding
import com.gaziev.dogsapirxjava2example.ui.screens.common.BaseFragment
import com.gaziev.dogsapirxjava2example.ui.screens.common.ViewModelFactory

class RandomDogFragment : BaseFragment<FragmentRandomDogBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRandomDogBinding =
        FragmentRandomDogBinding::inflate
    private val viewModel: RandomDogViewModel by viewModels { ViewModelFactory(activity?.application!!) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.dogImage.observe(viewLifecycleOwner) { url: String? ->
            if(url == null) {
                Glide
                    .with(this)
                    .load(R.drawable.failed_download)
                    .into(binding.dogContainer)

            } else {
                Glide
                    .with(this)
                    .load(url)
                    .placeholder(R.drawable.loading)
                    .into(binding.dogContainer)
            }
        }

        binding.get.setOnClickListener {
            viewModel.getRandomDog()
        }
    }
}