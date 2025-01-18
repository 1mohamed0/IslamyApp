package com.devoma.islamiapp.home.tabs.QuranTab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devoma.islamiapp.databinding.ItemSourahDetailsBinding

class VersesAdapter(private val Verse: List<String>) : RecyclerView.Adapter<VersesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemSourahDetailsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSourahDetailsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = Verse.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.sourahTv.text = Verse[position]
    }
}