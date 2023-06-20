package ru.anb.hammerapp.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import ru.anb.hammerapp.databinding.BannerLayoutBinding
import ru.anb.hammerapp.databinding.ItemMovieBinding
import ru.anb.hammerapp.databinding.TagsLayoutBinding
import ru.anb.hammerapp.model.BannerModel
import ru.anb.hammerapp.model.MovieModel
import ru.anb.hammerapp.model.TagModel

abstract class BaseViewHolder(private val binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun setData(data: Any)

}

class BannerViewHolder(private val binding: BannerLayoutBinding) : BaseViewHolder(binding) {

    override fun setData(data: Any) {
        val adapter = BannerAdapter()
        binding.bannerRecycler.adapter = adapter
        adapter.setData(data as List<BannerModel>)
    }
}

class TagListViewHolder(private val binding: TagsLayoutBinding) : BaseViewHolder(binding) {
    init {
        itemView.viewTreeObserver.addOnScrollChangedListener {
            val offSet = -itemView.top.toFloat()
            itemView.translationY = maxOf(0f, offSet)
            itemView.z = 1f
            Log.d("itemView", "${itemView.top}")
        }
    }
    override fun setData(data: Any) {
        val adapter = TagAdapter()
        binding.tagRecycler.adapter = adapter
        adapter.setData(data as List<TagModel>)
    }
}

class MovieViewHolder(private val binding: ItemMovieBinding) : BaseViewHolder(binding) {
    override fun setData(data: Any) {
        (data as MovieModel).let {
            with(binding) {
                mainName.text = it.category
                text.text = it.name
                Glide.with(itemView.context).load(it.imageUrl).into(binding.icon)
            }
        }
    }
}