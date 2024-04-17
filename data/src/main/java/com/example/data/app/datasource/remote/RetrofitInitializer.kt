package com.example.data.app.datasource.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInitializer {

  companion object {
    const val BASE_URL = "https://api.themoviedb.org/3/movie/"
  }

  private fun getLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    }
  }

  private fun getOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()

    builder
      .addInterceptor(getLoggingInterceptor())
      .readTimeout(30, TimeUnit.SECONDS)
      .connectTimeout(30, TimeUnit.SECONDS)

    return builder.build()
  }

  private fun getRetrofitClient(): Retrofit {
    val builder = Retrofit.Builder()

    builder
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .client(getOkHttpClient())

    return builder.build()
  }

  fun createApiService(): ApiService {
    return getRetrofitClient().create(ApiService::class.java)
  }
}
