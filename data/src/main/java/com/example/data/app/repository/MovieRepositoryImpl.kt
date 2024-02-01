package com.example.data.app.repository

import com.example.data.ApiService
import com.example.data.app.repository.dto.MovieResultDTO

class MovieRepositoryImpl(private val remoteDataSource: ApiService) : MovieRepository {

  override suspend fun getPopular(): MovieResultDTO {
    return remoteDataSource.getPopularMovie()
  }

  override suspend fun getTopRated(): MovieResultDTO {
    return remoteDataSource.getTopRated()
  }
}