package com.example.islamiapp.ui.screens.home.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.Model.Chapter
import com.example.islamiapp.databinding.ChapterLayoutBinding

class chapterAdapter(val chapter : List<Chapter> , val onItemClick : (Chapter ,Int) -> Unit) : Adapter<chapterAdapter.MyviewHolder>() {
    class MyviewHolder(val binding: ChapterLayoutBinding):ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
       val binding = ChapterLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyviewHolder(binding)
    }

    override fun getItemCount(): Int = chapter.size

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val chapter = chapter [position]
        holder.binding.chapterName.text = chapter.name
        holder.binding.ChapterVerses.text = chapter.verses
        holder.binding.root.setOnClickListener{
            onItemClick.invoke(chapter,position)
        }


    }
}