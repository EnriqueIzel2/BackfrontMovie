package com.example.data.app.repository.dto

import com.google.gson.annotations.SerializedName

data class MovieResultDTO(
  val results: List<MovieDTO>? = null,
  val page: Int? = null,
  @SerializedName("total_pages")
  val totalPages: Int? = null,
  @SerializedName("total_results")
  val totalResults: Int? = null
)
