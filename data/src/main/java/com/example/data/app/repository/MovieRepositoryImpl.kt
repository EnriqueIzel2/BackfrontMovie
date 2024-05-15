package com.example.data.app.repository

import com.example.data.app.datasource.local.dao.AppDAO
import com.example.data.app.datasource.remote.ApiService
import com.example.data.app.repository.dto.MovieResultDTO
import com.example.data.app.repository.model.Movie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
  private val remoteDataSource: ApiService,
  private val localDataSource: AppDAO
) : MovieRepository {

  override suspend fun getPopular(): MovieResultDTO {
    return remoteDataSource.getPopularMovie()
  }

  override suspend fun getTopRated(): MovieResultDTO {
    return remoteDataSource.getTopRated()
  }

  override suspend fun insertMovie(movie: Movie) {
    return localDataSource.insertMovie(movie)
  }

  override suspend fun getMovies(): List<Movie>? {
    return localDataSource.getMovies()
  }

  override suspend fun checkIfMovieIsSavedLocally(itemId: Int): Movie? {
    return localDataSource.checkIfIsMovieSavedLocally(itemId)
  }

  override suspend fun removeMovie(itemId: Int) {
    return localDataSource.removeMovie(itemId)
  }
}