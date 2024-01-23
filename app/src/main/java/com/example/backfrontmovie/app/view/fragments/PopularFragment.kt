package com.example.backfrontmovie.app.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.backfrontmovie.app.view.fragments.adapter.PopularAdapter
import com.example.backfrontmovie.app.viewmodel.MainViewModel
import com.example.backfrontmovie.app.viewmodel.MainViewModelFactory
import com.example.backfrontmovie.databinding.FragmentPopularBinding
import com.example.data.app.repository.model.Movie
import com.example.data.commons.viewstate.ViewState

class PopularFragment : Fragment() {

  private lateinit var binding: FragmentPopularBinding
  private val recyclerView by lazy { binding.popularRecyclerView }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentPopularBinding.inflate(
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
    val viewModel = MainViewModelFactory().create(MainViewModel::class.java)

    viewModel.popularMovies.observe(viewLifecycleOwner) {

      when (it) {
        is ViewState.Success -> setAdapter(it.data)
        else -> {
          Log.e("Erro", "erro ao iniciar o viewModel de popular")
        }
      }
    }

    viewModel.getPopular()
  }

  private fun setAdapter(data: List<Movie>?) {
    val popularAdapter = PopularAdapter(data.orEmpty())
    recyclerView.adapter = popularAdapter
  }
}