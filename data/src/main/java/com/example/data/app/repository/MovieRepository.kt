package com.example.data.app.repository

import com.example.data.app.repository.dto.MovieResultDTO

interface MovieRepository {
  suspend fun getPopular(): MovieResultDTO

  suspend fun getTopRated(): MovieResultDTO
}