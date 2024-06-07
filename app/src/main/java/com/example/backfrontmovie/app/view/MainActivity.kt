package com.example.backfrontmovie.app.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.backfrontmovie.R
import com.example.backfrontmovie.app.view.details.DetailsActivity
import com.example.backfrontmovie.app.view.login.LoginActivity
import com.example.backfrontmovie.app.viewmodel.LoginViewModel
import com.example.backfrontmovie.databinding.ActivityMainBinding
import com.example.data.app.repository.model.Movie
import com.google.firebase.messaging.FirebaseMessaging
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private val bottomNavigation by lazy { binding.mainBottomNavigation }

  private val loginViewModel by viewModel<LoginViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
    setContentView(binding.root)

    setupBottomNavigation()
    getToken()
  }

  private fun setupBottomNavigation() {
    val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    val navController = navHost.navController

    bottomNavigation.setupWithNavController(navController)
  }

  fun showDetailsActivity(item: Movie) {
    val intent = DetailsActivity.newIntent(this, item)

    val transitionOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
      this,
      binding.root as View,
      "transition_poster"
    )

    startActivity(intent, transitionOptions.toBundle())
  }

  private fun getToken() {
    FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
      if (task.isSuccessful) {
        val token = task.result
        Log.i("Firebase", "getToken: $token")
      }
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.main_menu, menu)

    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == R.id.menu_logout) {
      loginViewModel.logout()

      val intent = Intent(this, LoginActivity::class.java)
      intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
      startActivity(intent)

      return true
    }

    return super.onOptionsItemSelected(item)
  }
}