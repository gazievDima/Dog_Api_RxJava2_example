package com.gaziev.dogsapirxjava2example.presentation.screens.any

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.gaziev.dogsapirxjava2example.App
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.FragmentRandomDogBinding
import com.gaziev.dogsapirxjava2example.presentation.screens.common.BaseFragment
import javax.inject.Inject

class AnyDogFragment : BaseFragment<FragmentRandomDogBinding>() {
    override val title: String = "Random dog"
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRandomDogBinding =
        FragmentRandomDogBinding::inflate

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).daggerAppComponent.inject(this)
        val viewModel = ViewModelProvider(this, viewModelFactory)[AnyDogViewModel::class.java]


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