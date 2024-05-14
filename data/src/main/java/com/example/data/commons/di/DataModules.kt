package com.example.data.commons.di

import android.content.Context
import com.example.data.app.datasource.local.AppDatabase
import com.example.data.app.datasource.local.dao.AppDAO
import com.example.data.app.datasource.remote.RetrofitInitializer
import com.example.data.app.repository.MovieRepository
import com.example.data.app.repository.MovieRepositoryImpl
import com.example.data.app.usecase.MovieUseCase
import com.example.data.app.usecase.MovieUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val remoteServiceModule = module {
  single { RetrofitInitializer().createApiService() }
}

private val localServiceModule = module {
  fun provideDatabase(context: Context): AppDatabase {
    return AppDatabase.buildDatabase(context)
  }

  fun provideDao(appDatabase: AppDatabase): AppDAO {
    return appDatabase.appDAO
  }

  single { provideDatabase(androidContext()) }
  single { provideDao(get()) }
}

private val repositoryModule = module {
  factory<MovieRepository> { MovieRepositoryImpl(get(), get()) }
}

private val useCaseModule = module {
  single<MovieUseCase> { MovieUseCaseImpl(get()) }
}

fun getDataModules() =  listOf(
  remoteServiceModule,
  localServiceModule,
  repositoryModule,
  useCaseModule
)