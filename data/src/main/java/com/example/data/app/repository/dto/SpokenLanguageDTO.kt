package com.example.data.app.repository.dto


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpokenLanguageDTO(
  @SerializedName("english_name")
  val englishName: String?,
  @SerializedName("iso_639_1")
  val iso6391: String?,
  @SerializedName("name")
  val name: String?
) : Parcelable