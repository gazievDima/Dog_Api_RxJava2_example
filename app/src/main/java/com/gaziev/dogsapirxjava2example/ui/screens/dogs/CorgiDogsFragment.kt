package com.gaziev.dogsapirxjava2example.ui.screens.dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gaziev.dogsapirxjava2example.databinding.FragmentCorgiDogsBinding
import com.gaziev.dogsapirxjava2example.ui.screens.common.BaseFragment
import com.gaziev.dogsapirxjava2example.ui.screens.common.ViewModelFactory
import com.gaziev.dogsapirxjava2example.ui.screens.dogs.list.CorgiDogsAdapter

class CorgiDogsFragment : BaseFragment<FragmentCorgiDogsBinding>() {
    override val title: String = "List dogs by: Corgi"
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCorgiDogsBinding = FragmentCorgiDogsBinding::inflate
    private val viewModel: CorgiDogsViewModel by viewModels { ViewModelFactory(activity?.application!!) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listCorgi.observe(viewLifecycleOwner) { listCorgi: List<String?>? ->
            listCorgi?.let {
                binding.recycler.layoutManager = LinearLayoutManager(requireContext())
                binding.recycler.adapter = CorgiDogsAdapter(it)
            }
        }

        binding.get.setOnClickListener {
            viewModel.getListCorgiDogs()
        }
    }
}
