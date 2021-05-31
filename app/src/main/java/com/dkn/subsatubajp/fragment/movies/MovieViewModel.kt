package com.dkn.subsatubajp.fragment.movies

import androidx.lifecycle.ViewModel
import com.dkn.subsatubajp.data.Movie
import com.dkn.subsatubajp.utilis.DummyData

class MovieViewModel: ViewModel() {

    fun getListMovie(): List<Movie> {
        return DummyData.generateMovieListData()
    }
}