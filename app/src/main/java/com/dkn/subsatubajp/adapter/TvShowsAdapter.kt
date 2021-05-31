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
import com.dkn.subsatubajp.data.TvShowsData
import com.dkn.subsatubajp.databinding.ItemMoviesBinding

class TvShowsAdapter(
    private val itemList: List<TvShowsData>,
    private val context: Context,
    private val listener: IMovie? = null
) :
    RecyclerView.Adapter<TvShowsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(view.root)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = with(holder) {
        itemList[position].let { tvShow ->
            binding.textMovieName.text = tvShow.name
            binding.textYearMovie.text = tvShow.publishedYear
            binding.textMovieDescription.text = tvShow.description
            Glide.with(itemView.context)
                .load(tvShow.image)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(binding.imageMovies)
            binding.root.setOnClickListener {
                listener?.onMovieClicked(tvShow)
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
        fun onMovieClicked(tvShow: TvShowsData)
    }
}