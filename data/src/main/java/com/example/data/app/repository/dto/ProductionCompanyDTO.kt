package com.example.data.app.repository.dto


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductionCompanyDTO(
  @SerializedName("id")
  val id: Int?,
  @SerializedName("logo_path")
  val logoPath: String?,
  @SerializedName("name")
  val name: String?,
  @SerializedName("origin_country")
  val originCountry: String?
) : Parcelable