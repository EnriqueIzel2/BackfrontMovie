package com.example.backfrontmovie.app.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.app.datasource.local.AppDatabase
import com.example.data.app.datasource.remote.RetrofitInitializer
import com.example.data.app.repository.MovieRepositoryImpl
import com.example.data.app.usecase.MovieUseCaseImpl

class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
      val appDatabase = AppDatabase.buildDatabase(context)
      val appDao = appDatabase.appDAO
      val service = RetrofitInitializer().createApiService()
      val repository = MovieRepositoryImpl(service, appDao)
      val useCase = MovieUseCaseImpl(repository)

      return MainViewModel(useCase) as T
    }

    throw IllegalArgumentException("unknown view model class")
  }
}