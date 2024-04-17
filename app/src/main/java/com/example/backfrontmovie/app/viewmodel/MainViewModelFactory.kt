package com.example.backfrontmovie.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.app.datasource.remote.RetrofitInitializer
import com.example.data.app.repository.MovieRepositoryImpl
import com.example.data.app.usecase.MovieUseCaseImpl

class MainViewModelFactory : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
      val service = RetrofitInitializer().createApiService()
      val repository = MovieRepositoryImpl(service)
      val useCase = MovieUseCaseImpl(repository)

      return MainViewModel(useCase) as T
    }

    throw IllegalArgumentException("unknown view model class")
  }
}