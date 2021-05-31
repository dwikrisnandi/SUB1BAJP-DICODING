package com.dkn.subsatubajp.fragment.tv

import androidx.lifecycle.ViewModel
import com.dkn.subsatubajp.data.TvShowsData
import com.dkn.subsatubajp.utilis.DummyData

class TvShowViewModel : ViewModel() {

    fun getListTvShow(): List<TvShowsData> {
        return DummyData.generateTvShowListData()
    }
}