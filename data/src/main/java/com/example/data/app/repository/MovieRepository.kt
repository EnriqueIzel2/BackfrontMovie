package com.example.data.app.repository

import com.example.data.app.repository.dto.MovieResultDTO
import com.example.data.app.repository.model.Movie

interface MovieRepository {
  suspend fun getPopular(): MovieResultDTO
  suspend fun getTopRated(): MovieResultDTO

  suspend fun insertMovie(movie: Movie)
  suspend fun getMovies(): List<Movie>?
  suspend fun checkIfMovieIsSavedLocally(itemId: Int): Movie?
}