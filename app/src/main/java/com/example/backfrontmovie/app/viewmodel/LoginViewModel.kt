package com.example.backfrontmovie.app.viewmodel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.data.commons.viewstate.ViewState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel : ViewModel() {

  private val auth: FirebaseAuth = Firebase.auth
  private val _loginState = MediatorLiveData<ViewState<FirebaseUser?>>()
  val loginState: LiveData<ViewState<FirebaseUser?>> = _loginState.map { it }

  fun onStart() {
    val user = auth.currentUser

    if (user != null) {
      _loginState.value = ViewState.Success(user)
    } else {
      _loginState.value = ViewState.Error(Throwable("No user found"))
    }
  }

  fun login(activity: Activity, email: String, password: String) {
    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity) { task ->
      if (task.isSuccessful) {
        val user = auth.currentUser
        _loginState.value = ViewState.Success(user)
        Log.i("login", "login: usuário logou")
      } else {
        _loginState.value = ViewState.Error(Throwable("Erro ao logar usuário"))
      }
    }
  }

  fun logout() {
    auth.signOut()
  }
}