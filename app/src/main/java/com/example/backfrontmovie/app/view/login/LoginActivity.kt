package com.example.backfrontmovie.app.view.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.backfrontmovie.app.viewmodel.LoginViewModel
import com.example.backfrontmovie.databinding.ActivityLoginBinding
import com.example.data.commons.viewstate.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

  private val loginViewModel: LoginViewModel by viewModel()

  private lateinit var binding: ActivityLoginBinding
  private val loginButton by lazy { binding.loginButton }

  override fun onStart() {
    super.onStart()

    setObservable()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityLoginBinding.inflate(layoutInflater)
    setContentView(binding.root)

    handleLoginButton()
  }

  private fun handleLoginButton() {
    loginButton.setOnClickListener {
      loginViewModel.login(this, "teste@teste.com", "123456")
    }
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
}