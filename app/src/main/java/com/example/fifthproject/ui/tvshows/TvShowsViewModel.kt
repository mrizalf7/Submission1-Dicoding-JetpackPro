package com.example.fifthproject.ui.tvshows

import androidx.lifecycle.ViewModel
import com.example.fifthproject.data.TvShowsEntity
import com.example.fifthproject.utils.NotDataDummy

class TvShowsViewModel: ViewModel() {

    fun getTvShows():ArrayList<TvShowsEntity> = NotDataDummy.generateTvShows()

}