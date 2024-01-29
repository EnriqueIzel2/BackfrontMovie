package com.example.backfrontmovie.app.view.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.backfrontmovie.databinding.ActivityDetailsBinding
import com.example.data.app.repository.model.Movie

class DetailsActivity : AppCompatActivity() {

  private lateinit var binding: ActivityDetailsBinding
  private val detailsTitle by lazy { binding.detailsTitle }
  private val detailsBackground by lazy { binding.detailsBackground }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityDetailsBinding.inflate(layoutInflater)

    setContentView(binding.root)

    intent.extras?.let {
      val item = it.getParcelable("item") as Movie?

      setupItemView(item)
    }
  }

  private fun setupItemView(item: Movie?) {
    supportActionBar?.title = item?.title
    val postPath = "https://image.tmdb.org/t/p/w500${item?.backdropPath}"

    Glide.with(detailsBackground.context).load(postPath).into(detailsBackground)

    detailsTitle.text = item?.title
  }

  companion object {
    fun newIntent(context: Context, item: Movie): Intent {
      return Intent(context, DetailsActivity::class.java).apply {
        putExtra("item", item)
      }
    }
  }
}