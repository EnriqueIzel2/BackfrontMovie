package com.example.data

import com.example.data.app.repository.dto.MovieResultDTO
import com.example.data.donotshare.DEFAULT_API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

  companion object {
    const val API_KEY = DEFAULT_API_KEY
  }

  @GET("popular")
  suspend fun getPopularMovie(@Query("api_key") api: String = API_KEY): MovieResultDTO
}