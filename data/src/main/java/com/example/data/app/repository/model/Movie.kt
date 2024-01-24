package com.example.data.app.repository.model

import android.os.Parcelable
import com.example.data.app.repository.dto.GenreDTO
import com.example.data.app.repository.dto.ProductionCompanyDTO
import com.example.data.app.repository.dto.ProductionCountryDTO
import com.example.data.app.repository.dto.SpokenLanguageDTO
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Movie(
  val adult: Boolean? = null,
  val backdropPath: String? = null,
  val belongsToCollection: @RawValue Any? = null,
  val budget: Int? = null,
  val genres: List<GenreDTO?>? = null,
  val homepage: String? = null,
  val id: Int? = null,
  val imdbId: String? = null,
  val originalLanguage: String? = null,
  val originalTitle: String? = null,
  val overview: String? = null,
  val popularity: Double? = null,
  val posterPath: String? = null,
  val productionCompanies: List<ProductionCompanyDTO?>? = null,
  val productionCountries: List<ProductionCountryDTO?>? = null,
  val releaseDate: String? = null,
  val revenue: Int? = null,
  val runtime: Int? = null,
  val spokenLanguages: List<SpokenLanguageDTO?>? = null,
  val status: String? = null,
  val tagline: String? = null,
  val title: String? = null,
  val video: Boolean? = null,
  val voteAverage: Double? = null,
  val voteCount: Int? = null
) : Parcelable
