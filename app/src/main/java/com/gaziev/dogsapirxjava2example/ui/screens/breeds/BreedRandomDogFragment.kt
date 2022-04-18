package com.gaziev.dogsapirxjava2example.ui.screens.breeds

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gaziev.dogsapirxjava2example.databinding.FragmentBreedRandomDogBinding
import com.gaziev.dogsapirxjava2example.ui.screens.common.BaseFragment

class BreedRandomDogFragment : BaseFragment<FragmentBreedRandomDogBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBreedRandomDogBinding = FragmentBreedRandomDogBinding::inflate
}