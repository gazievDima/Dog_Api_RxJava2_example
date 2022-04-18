package com.gaziev.dogsapirxjava2example.ui.screens.random

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gaziev.dogsapirxjava2example.databinding.FragmentRandomDogBinding
import com.gaziev.dogsapirxjava2example.ui.screens.common.BaseFragment

class RandomDogFragment : BaseFragment<FragmentRandomDogBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRandomDogBinding = FragmentRandomDogBinding::inflate
}