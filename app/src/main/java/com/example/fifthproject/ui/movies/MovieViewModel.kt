package com.example.fifthproject.ui.movies

import androidx.lifecycle.ViewModel
import com.example.fifthproject.data.MoviesEntity
import com.example.fifthproject.utils.NotDataDummy

class MovieViewModel: ViewModel() {
    fun getMovies():ArrayList<MoviesEntity> = NotDataDummy.generateMovies()
}