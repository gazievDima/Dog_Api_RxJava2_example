package com.gaziev.dogsapirxjava2example.presentation.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.FragmentHomeBinding
import com.gaziev.dogsapirxjava2example.presentation.screens.common.BaseFragment
import com.gaziev.dogsapirxjava2example.presentation.screens.home.about.AboutDialogFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val title: String = "Welcome to app: Pesiki"
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.corgiDogs.setOnClickListener {
            findNavController().navigate(R.id.corgiDogsFragment)
        }
        binding.breedRandomDog.setOnClickListener {
            findNavController().navigate(R.id.breedRandomDogFragment)
        }
        binding.randomDog.setOnClickListener {
            findNavController().navigate(R.id.randomDogFragment)
        }
        binding.about.setOnClickListener {
            AboutDialogFragment().show(childFragmentManager, null)
        }
    }

}