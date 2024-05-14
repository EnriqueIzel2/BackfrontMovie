package com.example.backfrontmovie

import android.app.Application
import com.example.backfrontmovie.commons.di.getAppModules
import com.example.data.commons.di.getDataModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieApp : Application() {

  override fun onCreate() {
    super.onCreate()

    setupKoin()
  }

  private fun setupKoin() {
    startKoin {
      androidLogger()
      androidContext(this@MovieApp)
      modules(getAppModules() + getDataModules())
    }
  }
}