package com.example.backfrontmovie.app.view.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.backfrontmovie.R
import com.example.backfrontmovie.app.viewmodel.LoginViewModel
import com.example.data.commons.viewstate.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

  private val loginViewModel: LoginViewModel by viewModel()

  override fun onStart() {
    super.onStart()

    setObservable()
  }

  private fun setObservable() {
    loginViewModel.loginState.observe(this) { state ->
      when (state) {
        is ViewState.Success -> {
          Log.i("loginActivity", "setObservable: Usuário logado ${state.data}")
        }

        else -> {
          Log.e("loginActivity", "setObservable: $state")
        }
      }
    }

    loginViewModel.onStart()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)
  }
}