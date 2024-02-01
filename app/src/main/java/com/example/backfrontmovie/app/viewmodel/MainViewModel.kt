package com.example.backfrontmovie.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.data.app.repository.model.Movie
import com.example.data.app.usecase.MovieUseCase
import com.example.data.commons.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val useCase: MovieUseCase) : ViewModel() {

  private val _popularMovies = MediatorLiveData<ViewState<List<Movie>?>>()
  val popularMovies: LiveData<ViewState<List<Movie>?>> = _popularMovies.map { it }

  fun getPopular() {
    viewModelScope.launch(Dispatchers.Main) {
      runCatching {
        _popularMovies.value = ViewState.Loading(true)

        val response = withContext(Dispatchers.IO) {
          useCase.getPopular()
        }

        _popularMovies.value = response
      }.onFailure {
        _popularMovies.value = ViewState.Error(it)
      }.also {
        _popularMovies.value = ViewState.Loading(false)
      }
    }
  }

  private val _topRatedMovies = MediatorLiveData<ViewState<List<Movie>?>>()
  val topRatedMovies: LiveData<ViewState<List<Movie>?>> = _topRatedMovies.map { it }

  fun getTopRated() {
    viewModelScope.launch(Dispatchers.Main) {
      runCatching {
        _topRatedMovies.value = ViewState.Loading(true)

        val response = withContext(Dispatchers.IO) {
          useCase.getTopRated()
        }

        _topRatedMovies.value = response
      }.onFailure {
        _topRatedMovies.value = ViewState.Error(it)
      }.also {
        _topRatedMovies.value = ViewState.Loading(false)
      }
    }
  }
}