package com.example.backfrontmovie.commons.di

import android.content.Context
import com.example.data.app.datasource.local.AppDatabase
import com.example.data.app.datasource.local.dao.AppDAO
import com.example.data.app.datasource.remote.ApiService
import com.example.data.app.datasource.remote.RetrofitInitializer
import com.example.data.app.repository.MovieRepository
import com.example.data.app.repository.MovieRepositoryImpl
import com.example.data.app.usecase.MovieUseCase
import com.example.data.app.usecase.MovieUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModules {

  @Singleton
  @Provides
  fun provideServiceAPI(): ApiService {
    return RetrofitInitializer().createApiService()
  }

  @Singleton
  @Provides
  fun provideAppDao(@ApplicationContext context: Context): AppDAO {
    val database = AppDatabase.buildDatabase(context)

    return database.appDAO
  }

  @Singleton
  @Provides
  fun provideRepository(@ApplicationContext context: Context): MovieRepository {
    val api = provideServiceAPI()
    val appDao = provideAppDao(context)

    return MovieRepositoryImpl(api, appDao)
  }

  @Singleton
  @Provides
  fun provideUseCase(@ApplicationContext context: Context): MovieUseCase {
    val repository = provideRepository(context)

    return MovieUseCaseImpl(repository)
  }
}