package com.example.backfrontmovie.app.view.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.backfrontmovie.app.view.MainActivity
import com.example.backfrontmovie.app.viewmodel.LoginViewModel
import com.example.backfrontmovie.databinding.ActivityLoginBinding
import com.example.data.commons.viewstate.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

  private val loginViewModel: LoginViewModel by viewModel()

  private lateinit var binding: ActivityLoginBinding
  private val loginButton by lazy { binding.loginButton }

  private val loginEmail by lazy { binding.loginEmailContainer.editText?.text.toString() }
  private val loginPassword by lazy { binding.loginPasswordContainer.editText?.text.toString() }

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
    // TODO it needs a method to check if the field isn't null
    // Teste commitK
    loginButton.setOnClickListener {
      loginViewModel.login(this, loginEmail, loginPassword)
    }
  }

  private fun setObservable() {
    loginViewModel.loginState.observe(this) { state ->
      when (state) {
        is ViewState.Success -> {
          val intent = Intent(this, MainActivity::class.java)
          intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
          startActivity(intent)
        }

        else -> {
          Toast.makeText(this, "Erro ao realizar login", Toast.LENGTH_SHORT).show()
        }
      }
    }

    loginViewModel.onStart()
  }
}