package com.gaziev.dogsapirxjava2example.presentation.screens.dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gaziev.dogsapirxjava2example.App
import com.gaziev.dogsapirxjava2example.databinding.FragmentCorgiDogsBinding
import com.gaziev.dogsapirxjava2example.presentation.screens.common.BaseFragment
import com.gaziev.dogsapirxjava2example.presentation.screens.common.ViewModelFactory
import com.gaziev.dogsapirxjava2example.presentation.screens.dogs.list.CorgiDogsAdapter
import javax.inject.Inject

class CorgiDogsFragment : BaseFragment<FragmentCorgiDogsBinding>() {
    override val title: String = "List dogs by: Corgi"
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCorgiDogsBinding = FragmentCorgiDogsBinding::inflate
    //private val viewModel: CorgiDogsViewModel by viewModels { ViewModelFactory(activity?.application!!) }

    @Inject
    lateinit var viewModel: CorgiDogsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).daggerAppComponent.inject(this)

        viewModel.listCorgi.observe(viewLifecycleOwner) { listCorgi: List<String?>? ->
            listCorgi?.let {
                binding.recycler.layoutManager = LinearLayoutManager(requireContext())
                binding.recycler.adapter = CorgiDogsAdapter(it)
                binding.splash.visibility = View.GONE
            }
        }
    }
}
