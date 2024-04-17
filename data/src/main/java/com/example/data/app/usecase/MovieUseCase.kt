package com.example.data.app.usecase

import com.example.data.app.repository.model.Movie
import com.example.data.commons.viewstate.ViewState

interface MovieUseCase {
  suspend fun getPopular(): ViewState<List<Movie>?>
  suspend fun getTopRated(): ViewState<List<Movie>?>

  suspend fun insertMovie(movie: Movie): ViewState<Movie>
  suspend fun getMovies(): ViewState<List<Movie>?>
}