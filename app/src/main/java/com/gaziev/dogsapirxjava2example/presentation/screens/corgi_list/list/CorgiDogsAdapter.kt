package com.gaziev.dogsapirxjava2example.presentation.screens.corgi_list.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gaziev.dogsapirxjava2example.R

class CorgiDogsAdapter(
    private val list: List<String?>
) : RecyclerView.Adapter<CorgiDogsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorgiDogsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_corgi_dogs, parent, false)
        return CorgiDogsHolder(view)
    }

    override fun onBindViewHolder(holder: CorgiDogsHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}