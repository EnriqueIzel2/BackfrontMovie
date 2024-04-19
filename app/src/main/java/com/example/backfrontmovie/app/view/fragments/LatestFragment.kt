package com.example.backfrontmovie.app.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.backfrontmovie.app.view.MainActivity
import com.example.backfrontmovie.app.view.fragments.adapter.PopularAdapter
import com.example.backfrontmovie.app.viewmodel.MainViewModel
import com.example.backfrontmovie.app.viewmodel.MainViewModelFactory
import com.example.backfrontmovie.databinding.FragmentLatestBinding
import com.example.data.app.repository.model.Movie
import com.example.data.commons.viewstate.ViewState

class LatestFragment : Fragment() {

  private lateinit var binding: FragmentLatestBinding
  private val recyclerView by lazy { binding.latestRecyclerView }
  private val progressBar by lazy { binding.latestProgressBar }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentLatestBinding.inflate(
      inflater,
      container,
      false
    )

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setupViewModel()
  }

  private fun setupViewModel() {
    val viewModel = MainViewModelFactory(requireContext()).create(MainViewModel::class.java)

    viewModel.topRatedMovies.observe(viewLifecycleOwner) {

      when (it) {
        is ViewState.Loading -> handleLoading(it.loading)

        is ViewState.Success -> setAdapter(it.data)

        else -> {
          Log.e("Erro", "erro ao iniciar o viewModel de latest")
        }
      }
    }

    viewModel.getTopRated()
  }

  private fun handleLoading(mustShow: Boolean) {
    if (mustShow) {
      progressBar.isVisible = true
    } else {
      progressBar.isGone = true
    }
  }

  private fun setAdapter(data: List<Movie>?) {
    val popularAdapter = PopularAdapter(data.orEmpty()) {
      (requireActivity() as MainActivity).showDetailsActivity(it)
    }
    recyclerView.adapter = popularAdapter
  }
}