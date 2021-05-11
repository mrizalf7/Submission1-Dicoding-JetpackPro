package com.example.fifthproject.ui.tvshowdetail

import androidx.lifecycle.ViewModel
import com.example.fifthproject.data.TvShowsEntity
import com.example.fifthproject.utils.NotDataDummy

class TvShowsDetailViewModel: ViewModel() {

    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvShowsEntity {
        lateinit var tvShow: TvShowsEntity
        val tvShowsEntities = NotDataDummy.generateTvShows()
        for (tvShowsEntity in tvShowsEntities) {
            if (tvShowsEntity.tvShowId == tvShowId) {
                tvShow = tvShowsEntity
            }
        }
        return tvShow
    }

}