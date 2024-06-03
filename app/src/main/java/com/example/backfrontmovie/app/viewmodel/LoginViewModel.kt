package com.example.backfrontmovie.app.viewmodel

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
}