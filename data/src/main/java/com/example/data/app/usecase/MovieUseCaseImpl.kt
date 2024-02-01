package com.example.data.app.usecase

import com.example.data.app.repository.MovieRepository
import com.example.data.app.repository.model.Movie
import com.example.data.commons.mapper.MovieMapper
import com.example.data.commons.viewstate.ViewState

class MovieUseCaseImpl(private val repository: MovieRepository) : MovieUseCase {
  override suspend fun getPopular(): ViewState<List<Movie>?> {
    val response = repository.getPopular()

    val movies = MovieMapper.getMovieResponse(response)

    return ViewState.Success(movies)
  }

  override suspend fun getTopRated(): ViewState<List<Movie>?> {
    val response = repository.getTopRated()

    val movies = MovieMapper.getMovieResponse(response)

    return ViewState.Success(movies)
  }
}