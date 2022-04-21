package com.gaziev.dogsapirxjava2example.presentation.screens.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.gaziev.dogsapirxjava2example.presentation.MainActivity

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    abstract val title: String
    abstract val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB
    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(layoutInflater, container, false)

        (activity as MainActivity).toolbarChangeTitle(title)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}