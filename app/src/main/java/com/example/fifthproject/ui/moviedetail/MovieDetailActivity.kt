package com.example.fifthproject.ui.moviedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.fifthproject.R
import com.example.fifthproject.data.MoviesEntity
import com.example.fifthproject.databinding.ActivityMovieDetailBinding
import com.example.fifthproject.utils.NotDataDummy

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var movieDetailBinding:ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieDetailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(movieDetailBinding.root)
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieDetailViewModel::class.java]

        val actionbar = supportActionBar
        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)

                populateMovie(viewModel.getMovie())
                for (movie in NotDataDummy.generateMovies()) {
                    if (movie.movieId == movieId) {
                        populateMovie(movie)
                        actionbar?.title =movie.title
                    }
                }
            }
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun populateMovie(moviesEntity: MoviesEntity) {

        movieDetailBinding.movieTitle.text = moviesEntity.title
        movieDetailBinding.movieSynopsis.text = moviesEntity.synopsis
        movieDetailBinding.movieReleaseDate.text = resources.getString(R.string.release_date,moviesEntity.releaseDate)
        movieDetailBinding.movieScore.text = resources.getString(R.string.score,moviesEntity.score)


        Glide.with(this)
            .load(moviesEntity.image)
            .transform(RoundedCorners(120))
            .into(movieDetailBinding.movieDetailPoster)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}