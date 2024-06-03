package com.example.backfrontmovie.commons.di

import com.example.backfrontmovie.app.viewmodel.LoginViewModel
import com.example.backfrontmovie.app.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val viewModelModules = module {
  viewModel { MainViewModel(get()) }
  viewModel { LoginViewModel() }
}

fun getAppModules() = listOf(viewModelModules)