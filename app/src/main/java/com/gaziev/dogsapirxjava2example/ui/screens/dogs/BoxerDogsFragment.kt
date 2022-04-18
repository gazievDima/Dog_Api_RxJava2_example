package com.gaziev.dogsapirxjava2example.ui.screens.dogs

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gaziev.dogsapirxjava2example.databinding.FragmentBoxerDogsBinding
import com.gaziev.dogsapirxjava2example.ui.screens.common.BaseFragment

class BoxerDogsFragment : BaseFragment<FragmentBoxerDogsBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBoxerDogsBinding = FragmentBoxerDogsBinding::inflate
}