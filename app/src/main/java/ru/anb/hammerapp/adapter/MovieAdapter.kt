package ru.anb.hammerapp.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.anb.hammerapp.databinding.BannerLayoutBinding
import ru.anb.hammerapp.databinding.ItemMovieBinding
import ru.anb.hammerapp.databinding.TagsLayoutBinding
import ru.anb.hammerapp.model.ItemType
import ru.anb.hammerapp.model.MovieModel

class MovieAdapter() : RecyclerView.Adapter<BaseViewHolder>() {

    private var movieItems: List<Any> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ItemType.BANNER_LIST.ordinal -> BannerViewHolder(
                BannerLayoutBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            ItemType.TAG_LIST.ordinal -> TagListViewHolder(
                TagsLayoutBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            else -> MovieViewHolder(
                ItemMovieBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = movieItems[position]
        holder.setData(item)

    }

    override fun getItemCount() = movieItems.size

    @SuppressLint("NotifyDataSetChanged")
    fun setMovies(movies: List<Any>) {
        Log.d("adapter", "$movies")
        movieItems = movies
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ItemType.BANNER_LIST.ordinal
            1 -> ItemType.TAG_LIST.ordinal
            else -> ItemType.MOVIE.ordinal
        }
    }

}