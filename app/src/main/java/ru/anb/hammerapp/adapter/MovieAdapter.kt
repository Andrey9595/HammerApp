package ru.anb.hammerapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.anb.hammerapp.databinding.ItemMovieBinding
import ru.anb.hammerapp.model.Model

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var startItems: List<Model> = emptyList()

    class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = startItems[position]
        with(holder.binding) {
            mainName.text = movie.category
            text.text = movie.name
            Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.icon)
        }
    }

    override fun getItemCount() = startItems.size

    @SuppressLint("NotifyDataSetChanged")
    fun setMovies(movies: List<Model>) {
        startItems = movies
        notifyDataSetChanged()
    }

}