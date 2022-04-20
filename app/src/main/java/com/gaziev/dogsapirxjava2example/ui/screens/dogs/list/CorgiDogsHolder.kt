package com.gaziev.dogsapirxjava2example.ui.screens.dogs.list

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gaziev.dogsapirxjava2example.R
import com.gaziev.dogsapirxjava2example.databinding.ItemCorgiDogsBinding

class CorgiDogsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(dogImage: String?) {

        val dogContainer = itemView.findViewById<ImageView>(R.id.dogContainer)
        if(dogImage == null) {
            Glide
                .with(itemView)
                .load(R.drawable.failed_download)
                .into(dogContainer)

        } else {
            Glide
                .with(itemView)
                .load(dogImage)
                .placeholder(R.drawable.loading)
                .into(dogContainer)
        }

    }
}