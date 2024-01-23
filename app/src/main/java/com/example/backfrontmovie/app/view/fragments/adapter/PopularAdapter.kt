package com.example.backfrontmovie.app.view.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.backfrontmovie.databinding.PopularItemViewBinding
import com.example.data.app.repository.model.Movie

class PopularAdapter(private val items: List<Movie>) : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

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
        binding.textView.text = item.originalTitle
      }
    }
}