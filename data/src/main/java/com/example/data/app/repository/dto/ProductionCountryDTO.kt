package com.example.data.app.repository.dto


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductionCountryDTO(
  @SerializedName("iso_3166_1")
  val iso31661: String?,
  @SerializedName("name")
  val name: String?
) : Parcelable