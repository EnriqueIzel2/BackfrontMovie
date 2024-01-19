package com.example.backfrontmovie.app.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.backfrontmovie.R
import com.example.backfrontmovie.app.viewmodel.MainViewModel
import com.example.backfrontmovie.app.viewmodel.MainViewModelFactory
import com.example.backfrontmovie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private val bottomNavigation by lazy { binding.mainBottomNavigation }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
    setContentView(binding.root)

    setupBottomNavigation()

    val viewModel = MainViewModelFactory().create(MainViewModel::class.java)

    viewModel.popularMovies.observe(this) {
      Log.i("Result", "onCreate: lista de filmes $it")
    }

    viewModel.getPopular()
  }

  private fun setupBottomNavigation() {
    val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    val navController = navHost.navController

    bottomNavigation.setupWithNavController(navController)
  }
}