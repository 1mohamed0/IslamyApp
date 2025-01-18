package com.devoma.islamiapp.home.tabs.QuranTab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devoma.islamiapp.databinding.ItemVerseBinding
import com.devoma.islamiapp.model.Chapter

class quranAdabter(val chapters :List<Chapter>,
) : RecyclerView.Adapter<quranAdabter.viewHolder>()
{

    class viewHolder(val itemBinding: ItemVerseBinding): RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemBinding = ItemVerseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return viewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val chapter = chapters[position]
        holder.itemBinding.versesNumberAr.text = chapter.nameAr
        holder.itemBinding.versesNameEng.text = chapter.nameEN
        holder.itemBinding.ayathNum.text = chapter.ayaytNumber
        holder.itemBinding.versesNumber.text = "${chapter.INDEX+1}"
        onItemClicks?.let { onClick ->
            holder.itemView.setOnClickListener{
                onClick.onItemClick(position,chapter)

            }
        }
    }
    var onItemClicks : onItemClick? = null
    fun interface onItemClick{
        fun onItemClick(position: Int, chapter: Chapter)
    }


}