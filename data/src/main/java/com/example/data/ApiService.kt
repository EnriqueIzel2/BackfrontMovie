package com.example.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

  companion object {
    const val API_KEY = ""
  }

  @GET("popular")
  fun getPopularMovie(@Query("api_key") api: String = API_KEY)
}