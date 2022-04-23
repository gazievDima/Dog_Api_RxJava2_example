package com.gaziev.dogsapirxjava2example.presentation.screens.corgi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.gaziev.dogsapirxjava2example.App
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.FragmentDogBinding
import com.gaziev.dogsapirxjava2example.presentation.screens.common.BaseFragment
import javax.inject.Inject

class CorgiDogFragment : BaseFragment<FragmentDogBinding>() {
    override val title: String = "Random dog by breed: Corgi"
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDogBinding =
        FragmentDogBinding::inflate

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).daggerAppComponent.inject(this)
        val viewModel = ViewModelProvider(this, viewModelFactory)[CorgiDogViewModel::class.java]

        viewModel.imageUrl.observe(viewLifecycleOwner) { url: String? ->
            val res = url ?: R.drawable.failed
            setImage(res)
            binding.splash.visibility = View.GONE
        }

        binding.btnReplace.setOnClickListener {
            viewModel.getBreedRandomDog()
        }
    }

    private fun setImage(url: Any) {
        Glide
            .with(this)
            .load(url)
            .placeholder(R.drawable.holder_loading)
            .into(binding.ivContainer)
    }
}