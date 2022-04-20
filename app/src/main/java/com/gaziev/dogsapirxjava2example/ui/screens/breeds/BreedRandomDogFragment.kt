package com.gaziev.dogsapirxjava2example.ui.screens.breeds

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.FragmentBreedRandomDogBinding
import com.gaziev.dogsapirxjava2example.ui.screens.common.BaseFragment
import com.gaziev.dogsapirxjava2example.ui.screens.common.ViewModelFactory
import com.gaziev.dogsapirxjava2example.ui.screens.random.RandomDogViewModel

class BreedRandomDogFragment : BaseFragment<FragmentBreedRandomDogBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBreedRandomDogBinding = FragmentBreedRandomDogBinding::inflate
    private val viewModel: BreedRandomDogViewModel by viewModels { ViewModelFactory(activity?.application!!) }

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
            viewModel.getBreedRandomDog()
        }
    }
}