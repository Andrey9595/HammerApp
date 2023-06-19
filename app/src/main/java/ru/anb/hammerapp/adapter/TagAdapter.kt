package ru.anb.hammerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.anb.hammerapp.databinding.TagItemBinding

class TagAdapter() : RecyclerView.Adapter<TagAdapter.TagViewHolder>() {

    private var tagList = emptyList<String>()

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
        holder.binding.tagText.text = tag
    }

    override fun getItemCount() = tagList.size

    fun setData(data: List<String>){
        tagList = data
        notifyDataSetChanged()
    }
}