package com.gaziev.dogsapirxjava2example.presentation.screens.corgi_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gaziev.dogsapirxjava2example.App
import com.gaziev.dogsapirxjava2example.databinding.FragmentCorgiDogsBinding
import com.gaziev.dogsapirxjava2example.presentation.screens.common.BaseFragment
import com.gaziev.dogsapirxjava2example.presentation.screens.corgi_list.list.CorgiDogsAdapter
import javax.inject.Inject

class CorgiDogsFragment : BaseFragment<FragmentCorgiDogsBinding>() {
    override val title: String = "List dogs by: Corgi"
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCorgiDogsBinding = FragmentCorgiDogsBinding::inflate

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).daggerAppComponent.inject(this)
        val viewModel = ViewModelProvider(this, viewModelFactory)[CorgiDogsViewModel::class.java]

        viewModel.listImageUrl.observe(viewLifecycleOwner) { listCorgi: List<String?>? ->
            listCorgi?.let {
                binding.recycler.layoutManager = LinearLayoutManager(requireContext())
                binding.recycler.adapter = CorgiDogsAdapter(it)
                binding.splash.visibility = View.GONE
            }
        }
    }
}
