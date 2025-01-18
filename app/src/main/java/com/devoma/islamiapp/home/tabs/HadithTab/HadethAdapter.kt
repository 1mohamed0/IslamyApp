package com.devoma.islamiapp.home.tabs.HadithTab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devoma.islamiapp.databinding.ItemHadethBinding
import com.devoma.islamiapp.model.Hadeth

class HadethAdapter(val hadethLista : List<Hadeth>) : RecyclerView.Adapter<HadethAdapter.ViewHolder>() {
    class ViewHolder(val viewBindung: ItemHadethBinding) : RecyclerView.ViewHolder(viewBindung.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding  = ItemHadethBinding.inflate(LayoutInflater.from(parent.context)
        ,parent,false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = hadethLista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadethLista = hadethLista[position]
        holder.viewBindung.title.text = hadethLista.title
        holder.viewBindung.contnt.text = hadethLista.content
    }
}