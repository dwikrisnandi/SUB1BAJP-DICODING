package com.dkn.subsatubajp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dkn.subsatubajp.R
import com.dkn.subsatubajp.data.Movie
import com.dkn.subsatubajp.databinding.ItemMoviesBinding

class MoviesAdapter (
    private val itemList: List<Movie>,
    private val context: Context,
    private val listener: IMovie? = null
) :
    RecyclerView.Adapter<MoviesAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(view.root)
    }

    @SuppressLint
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = with(holder) {
        itemList[position].let { movie ->
            binding.textMovieName.text = movie.name
            binding.textYearMovie.text = movie.publishedYear
            binding.textMovieDescription.text = movie.description
            Glide.with(itemView.context)
                .load(movie.image)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(binding.imageMovies)
            binding.root.setOnClickListener {
                listener?.onMovieClicked(movie)
            }
        }
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemMoviesBinding.bind(itemView)
    }

    interface IMovie {
        fun onMovieClicked(movie: Movie)
    }
}