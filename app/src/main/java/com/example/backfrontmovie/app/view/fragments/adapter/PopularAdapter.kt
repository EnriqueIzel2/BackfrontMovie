package com.example.backfrontmovie.app.view.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.backfrontmovie.commons.extensions.formatToLatamDate
import com.example.backfrontmovie.databinding.PopularItemViewBinding
import com.example.data.app.repository.model.Movie

class PopularAdapter(
  private val items: List<Movie>,
  private val onClickListener: ((Movie) -> Unit)
) :
  RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = PopularItemViewBinding.inflate(
      inflater,
      parent,
      false
    )

    return ViewHolder(binding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = items[position]

    holder.bind(item)
  }

  override fun getItemCount(): Int = items.size

  inner class ViewHolder(private val binding: PopularItemViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Movie) {
      binding.cardMovieTitle.text = item.originalTitle

      val postPath = "https://image.tmdb.org/t/p/w185${item.posterPath}"
      Glide.with(binding.root.context).load(postPath).into(binding.cardMoviePoster)

      binding.cardMovieReleaseDate.text = item.releaseDate?.formatToLatamDate()
      binding.cardMovieOverview.text = item.overview

      itemView.setOnClickListener {
        onClickListener.invoke(item)
      }
    }
  }
}