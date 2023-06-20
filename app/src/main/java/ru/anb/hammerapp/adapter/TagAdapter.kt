package ru.anb.hammerapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.anb.hammerapp.databinding.TagItemBinding
import ru.anb.hammerapp.model.TagModel

class TagAdapter() : RecyclerView.Adapter<TagAdapter.TagViewHolder>() {

    private var tagList = emptyList<TagModel>()

    class TagViewHolder(val binding: TagItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        return TagViewHolder(
            TagItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        val tag = tagList[position]
        holder.binding.tagText.text = tag.tagText
    }

    override fun getItemCount() = tagList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<TagModel>){
        tagList = data
        notifyDataSetChanged()
    }
}