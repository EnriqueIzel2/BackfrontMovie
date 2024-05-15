package com.example.data.app.usecase

import com.example.data.app.repository.MovieRepository
import com.example.data.app.repository.model.Movie
import com.example.data.commons.mapper.MovieMapper
import com.example.data.commons.viewstate.ViewState
import javax.inject.Inject

class MovieUseCaseImpl @Inject constructor(private val repository: MovieRepository) : MovieUseCase {
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

  override suspend fun insertMovie(movie: Movie): ViewState<Movie> {
    return try {
      repository.insertMovie(movie)
      ViewState.Success(movie)
    } catch (e: Exception) {
      ViewState.Error(e)
    }
  }

  override suspend fun getMovies(): ViewState<List<Movie>?> {
    return try {
      val movies = repository.getMovies()
      ViewState.Success(movies)
    } catch (e: Exception) {
      ViewState.Error(e)
    }
  }

  override suspend fun checkIfMovieIsSavedLocally(itemId: Int): Movie? {
    return try {
      val movie = repository.checkIfMovieIsSavedLocally(itemId)
      movie
    } catch (e: Exception) {
      null
    }
  }

  override suspend fun removeMovie(itemId: Int): ViewState<Boolean> {
    return try {
      repository.removeMovie(itemId).let { ViewState.Success(true) }
    } catch (e: Exception) {
      ViewState.Error(e)
    }
  }
}