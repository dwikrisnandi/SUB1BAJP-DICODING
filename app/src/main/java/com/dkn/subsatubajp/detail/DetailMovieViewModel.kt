package com.dkn.subsatubajp.detail

import androidx.lifecycle.ViewModel
import com.dkn.subsatubajp.data.Movie
import com.dkn.subsatubajp.data.TvShowsData
import com.dkn.subsatubajp.utilis.DummyData

class DetailMovieViewModel : ViewModel() {

    private lateinit var selectedId: String

    fun setSelectedId(selectedId: String) {
        this.selectedId = selectedId
    }

    fun getDetailMovie(): Movie {
        lateinit var movie: Movie
        val movies = DummyData.generateMovieListData()
        movies.forEach { data ->
            if (selectedId == data.id.toString()) {
                movie = data
            }
        }
        return movie
    }

    fun getDetailTvShow(): TvShowsData {
        lateinit var tvShow: TvShowsData
        val tvShows = DummyData.generateTvShowListData()
        tvShows.forEach { data ->
            if (selectedId == data.id.toString()) {
                tvShow = data
            }
        }
        return tvShow
    }
}