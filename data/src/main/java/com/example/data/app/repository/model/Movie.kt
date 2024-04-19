package com.example.data.app.repository.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.data.app.repository.dto.GenreDTO
import com.example.data.app.repository.dto.ProductionCompanyDTO
import com.example.data.app.repository.dto.ProductionCountryDTO
import com.example.data.app.repository.dto.SpokenLanguageDTO
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
@Entity("movie")
data class Movie(
  @PrimaryKey
  var id: Int? = null,
  var adult: Boolean? = null,
  var backdropPath: String? = null,
  @Ignore
  var belongsToCollection: @RawValue Any? = null,
  var budget: Int? = null,
  @Ignore
  var genres: List<GenreDTO?>? = null,
  var homepage: String? = null,
  var imdbId: String? = null,
  var originalLanguage: String? = null,
  var originalTitle: String? = null,
  var overview: String? = null,
  var popularity: Double? = null,
  var posterPath: String? = null,
  @Ignore
  var productionCompanies: List<ProductionCompanyDTO?>? = null,
  @Ignore
  var productionCountries: List<ProductionCountryDTO?>? = null,
  var releaseDate: String? = null,
  var revenue: Int? = null,
  var runtime: Int? = null,
  @Ignore
  var spokenLanguages: List<SpokenLanguageDTO?>? = null,
  var status: String? = null,
  var tagline: String? = null,
  var title: String? = null,
  var video: Boolean? = null,
  var voteAverage: Double? = null,
  var voteCount: Int? = null
) : Parcelable
