package com.example.data.commons.mapper

import com.example.data.app.repository.dto.MovieResultDTO
import com.example.data.app.repository.dto.toMovie
import com.example.data.app.repository.model.Movie

object MovieMapper {
  fun getMovieResponse(movieResultDTO: MovieResultDTO): List<Movie>? {
    return movieResultDTO.results?.map { it.toMovie() }
  }
}