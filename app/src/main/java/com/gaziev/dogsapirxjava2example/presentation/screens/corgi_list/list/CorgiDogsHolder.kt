package com.gaziev.dogsapirxjava2example.presentation.screens.corgi_list.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.ItemCorgiDogsBinding

class CorgiDogsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemCorgiDogsBinding.bind(itemView)

    fun bind(dogImage: String?) {
       val res = dogImage ?: R.drawable.failed
        setImage(res)
    }

    private fun setImage(url: Any) {
        Glide
            .with(itemView)
            .load(url)
            .placeholder(R.drawable.holder_loading)
            .into(binding.dogContainer)
    }
}