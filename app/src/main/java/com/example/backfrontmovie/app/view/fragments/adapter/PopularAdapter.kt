package com.example.backfrontmovie.app.view.fragments.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.backfrontmovie.databinding.PopularItemViewBinding
import com.example.data.app.repository.model.Movie

class PopularAdapter(private val items: List<Movie>) : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    TODO("Not yet implemented")
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    TODO("Not yet implemented")
  }

  override fun getItemCount(): Int = items.size

  inner class ViewHolder(private val binding: PopularItemViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

      fun bind() {
        // TODO fazer o bindings dos textos
      }
    }
}