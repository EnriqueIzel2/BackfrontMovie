package com.example.backfrontmovie.app.view.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.backfrontmovie.app.viewmodel.MainViewModel
import com.example.backfrontmovie.app.viewmodel.MainViewModelFactory
import com.example.backfrontmovie.commons.extensions.formatToLatamDate
import com.example.backfrontmovie.databinding.ActivityDetailsBinding
import com.example.data.app.repository.model.Movie
import com.example.data.commons.viewstate.ViewState

class DetailsActivity : AppCompatActivity() {

  private lateinit var binding: ActivityDetailsBinding
  private val detailsTitle by lazy { binding.detailsTitle }
  private val detailsBackground by lazy { binding.detailsBackground }
  private val detailsReleaseDate by lazy { binding.detailsReleaseDate }
  private val detailsPoster by lazy { binding.detailsPoster }
  private val detailsOverview by lazy { binding.detailsOverview }
  private val addButton by lazy { binding.detailsButtonAddFavorite }

  private lateinit var viewModel: MainViewModel
  private var movie: Movie? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityDetailsBinding.inflate(layoutInflater)

    setContentView(binding.root)

    intent.extras?.let {
      movie = it.getParcelable("item") as Movie?

      setupItemView(movie)
    }

    setupOnClickListener()
    setupViewModel()
  }

  private fun setupItemView(item: Movie?) {
    supportActionBar?.title = item?.title
    val backgroundPath = "https://image.tmdb.org/t/p/w500${item?.backdropPath}"
    val posterPath = "https://image.tmdb.org/t/p/w185${item?.posterPath}"

    Glide.with(detailsBackground.context).load(backgroundPath).into(detailsBackground)
    Glide.with(detailsPoster.context).load(posterPath).into(detailsPoster)

    detailsTitle.text = item?.title
    detailsReleaseDate.text = item?.releaseDate?.formatToLatamDate()
    detailsOverview.text = item?.overview
  }

  private fun setupOnClickListener() {
    addButton.setOnClickListener {
      movie?.let {
        viewModel.insertMovie(it)
      }
    }
  }

  private fun setupViewModel() {
    viewModel = MainViewModelFactory(this).create(MainViewModel::class.java)
    viewModel.insertMovie.observe(this) { state ->
      when (state) {
        is ViewState.Success -> {
          viewModel.getMovies()
        }

        is ViewState.Error -> {
          state.throwable
        }

        else -> {
          //
        }
      }
    }

    viewModel.getMovies.observe(this) { state ->
      when (state) {
        is ViewState.Success -> {
          Log.i("Details", "setupViewModel: ${state.data?.size}")
        }

        is ViewState.Error -> {
          state.throwable
        }

        else -> {

        }
      }
    }
  }

  companion object {
    fun newIntent(context: Context, item: Movie): Intent {
      return Intent(context, DetailsActivity::class.java).apply {
        putExtra("item", item)
      }
    }
  }
}