package com.example.backfrontmovie.app.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.backfrontmovie.app.view.MainActivity
import com.example.backfrontmovie.app.view.fragments.adapter.PopularAdapter
import com.example.backfrontmovie.app.viewmodel.MainViewModel
import com.example.backfrontmovie.databinding.FragmentPopularBinding
import com.example.data.app.repository.model.Movie
import com.example.data.commons.viewstate.ViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularFragment : Fragment() {

  private lateinit var binding: FragmentPopularBinding
  private val recyclerView by lazy { binding.popularRecyclerView }
  private val progressBar by lazy { binding.popularProgressBar }

  private val viewModel: MainViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    if (!::binding.isInitialized) {
      binding = FragmentPopularBinding.inflate(
        inflater,
        container,
        false
      )
    }

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setupViewModel()
  }

  private fun setupViewModel() {
    viewModel.popularMovies.observe(viewLifecycleOwner) {

      when (it) {
        is ViewState.Loading -> handleLoading(it.loading)
        is ViewState.Success -> setAdapter(it.data)
        else -> {
          Log.e("Erro", "erro ao iniciar o viewModel de popular")
        }
      }
    }

    viewModel.getPopular()
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