package com.example.backfrontmovie.app.view.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.backfrontmovie.databinding.ActivityDetailsBinding
import com.example.data.app.repository.model.Movie

class DetailsActivity : AppCompatActivity() {

  private lateinit var binding: ActivityDetailsBinding
  private val detailsTitle by lazy { binding.detailsTitle }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityDetailsBinding.inflate(layoutInflater)

    setContentView(binding.root)

    intent.extras?.let {
      val item = it.getParcelable("item") as Movie?
      detailsTitle.text = item?.title
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