package com.example.data.app.repository.dto


import com.example.data.app.repository.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieDTO(
  @SerializedName("adult")
  val adult: Boolean? = null,
  @SerializedName("backdrop_path")
  val backdropPath: String? = null,
  @SerializedName("belongs_to_collection")
  val belongsToCollection: Any? = null,
  @SerializedName("budget")
  val budget: Int? = null,
  @SerializedName("genres")
  val genres: List<GenreDTO?>? = null,
  @SerializedName("homepage")
  val homepage: String? = null,
  @SerializedName("id")
  val id: Int? = null,
  @SerializedName("imdb_id")
  val imdbId: String? = null,
  @SerializedName("original_language")
  val originalLanguage: String? = null,
  @SerializedName("original_title")
  val originalTitle: String? = null,
  @SerializedName("overview")
  val overview: String? = null,
  @SerializedName("popularity")
  val popularity: Double? = null,
  @SerializedName("poster_path")
  val posterPath: String? = null,
  @SerializedName("production_companies")
  val productionCompanies: List<ProductionCompanyDTO?>? = null,
  @SerializedName("production_countries")
  val productionCountries: List<ProductionCountryDTO?>? = null,
  @SerializedName("release_date")
  val releaseDate: String? = null,
  @SerializedName("revenue")
  val revenue: Int? = null,
  @SerializedName("runtime")
  val runtime: Int? = null,
  @SerializedName("spoken_languages")
  val spokenLanguages: List<SpokenLanguageDTO?>? = null,
  @SerializedName("status")
  val status: String? = null,
  @SerializedName("tagline")
  val tagline: String? = null,
  @SerializedName("title")
  val title: String? = null,
  @SerializedName("video")
  val video: Boolean? = null,
  @SerializedName("vote_average")
  val voteAverage: Double? = null,
  @SerializedName("vote_count")
  val voteCount: Int? = null
)

fun MovieDTO.toMovie(): Movie {
  return Movie(
    adult,
    backdropPath,
    belongsToCollection,
    budget,
    genres,
    homepage,
    id,
    imdbId,
    originalLanguage,
    originalTitle,
    overview,
    popularity,
    posterPath,
    productionCompanies,
    productionCountries,
    releaseDate,
    revenue,
    runtime,
    spokenLanguages,
    status,
    tagline,
    title,
    video,
    voteAverage,
    voteCount
  )
}