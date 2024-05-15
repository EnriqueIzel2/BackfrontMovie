package com.example.backfrontmovie.app.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.backfrontmovie.app.view.MainActivity
import com.example.backfrontmovie.app.view.fragments.adapter.PopularAdapter
import com.example.backfrontmovie.app.viewmodel.MainViewModel
import com.example.backfrontmovie.databinding.FragmentFavoriteBinding
import com.example.data.commons.viewstate.ViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

  private lateinit var binding: FragmentFavoriteBinding
  private val recyclerView by lazy { binding.recyclerViewFavorite }
  private lateinit var mAdapter: PopularAdapter

  private val viewModel: MainViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentFavoriteBinding.inflate(inflater, container, false)

    return binding.root
  }

  override fun onResume() {
    super.onResume()

    setupViewModel()
  }

  private fun setupViewModel() {
    viewModel.getMovies.observe(viewLifecycleOwner) { state ->
      when (state) {
        is ViewState.Success -> {
          mAdapter = PopularAdapter(state.data.orEmpty()) { movie ->
            (requireActivity() as MainActivity).showDetailsActivity(movie)
          }
          recyclerView.adapter = mAdapter
        }

        is ViewState.Error -> {
          state.throwable
        }

        else -> {
          Log.e("Favorite Fragment", "setupViewModel: Erro ao inicializar a viewModel")
        }
      }
    }

    viewModel.getMovies()
  }
}