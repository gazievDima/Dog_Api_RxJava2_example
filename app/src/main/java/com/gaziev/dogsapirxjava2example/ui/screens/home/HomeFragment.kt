package com.gaziev.dogsapirxjava2example.ui.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.FragmentHomeBinding
import com.gaziev.dogsapirxjava2example.ui.screens.breed.BreedRandomDogFragment
import com.gaziev.dogsapirxjava2example.ui.screens.common.BaseFragment
import com.gaziev.dogsapirxjava2example.ui.screens.dogs.CorgiDogsFragment
import com.gaziev.dogsapirxjava2example.ui.screens.home.about.AboutDialogFragment
import com.gaziev.dogsapirxjava2example.ui.screens.random.RandomDogFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val title: String = "Welcome to app: Pesiki"
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.corgiDogs.setOnClickListener {
            openFragment(CorgiDogsFragment())
        }
        binding.breedRandomDog.setOnClickListener {
            openFragment(BreedRandomDogFragment())
        }
        binding.randomDog.setOnClickListener {
            openFragment(RandomDogFragment())
        }
        binding.about.setOnClickListener {
            AboutDialogFragment().show(childFragmentManager, null)
        }
    }

    private fun openFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

}