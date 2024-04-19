package com.example.backfrontmovie.app.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.backfrontmovie.app.view.MainActivity
import com.example.backfrontmovie.app.view.fragments.adapter.PopularAdapter
import com.example.backfrontmovie.app.viewmodel.MainViewModel
import com.example.backfrontmovie.app.viewmodel.MainViewModelFactory
import com.example.backfrontmovie.databinding.FragmentFavoriteBinding
import com.example.data.commons.viewstate.ViewState

class FavoriteFragment : Fragment() {

  private lateinit var binding: FragmentFavoriteBinding
  private val recyclerView by lazy { binding.recyclerViewFavorite }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentFavoriteBinding.inflate(inflater, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setupViewModel()
  }

  private fun setupViewModel() {
    val viewModel = MainViewModelFactory(requireContext()).create(MainViewModel::class.java)

    viewModel.getMovies.observe(viewLifecycleOwner) { state ->
      when (state) {
        is ViewState.Success -> {
          Log.i("Details", "setupViewModel: ${state.data?.size}")

          val mAdapter = PopularAdapter(state.data.orEmpty()) { movie ->
            (requireActivity() as MainActivity).showDetailsActivity(movie)
          }
          recyclerView.adapter = mAdapter
        }

        is ViewState.Error -> {
          state.throwable
        }

        else -> {

        }
      }
    }

    viewModel.getMovies()
  }
}