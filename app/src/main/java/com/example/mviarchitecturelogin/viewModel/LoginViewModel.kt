package com.example.mviarchitecturelogin.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mviarchitecturelogin.intent.LoginIntent
import com.example.mviarchitecturelogin.model.LoginRequest
import com.example.mviarchitecturelogin.model.LoginState
import com.example.mviarchitecturelogin.retrofitApi.RetrofitInstance
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun onIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.EnterEmail -> {
                _state.value = _state.value.copy(email = intent.email)
            }
            is LoginIntent.EnterPassword -> {
                _state.value = _state.value.copy(password = intent.password)
            }
            LoginIntent.Submit -> {
                login(_state.value.email, _state.value.password)
            }
        }
    }

    private fun login(email: String, password: String) {
        _state.value = _state.value.copy(isLoading = true, error = null)
        // for testing purpose
//        viewModelScope.launch {
//            delay(1000) // simulate network call
//            if (email == "test@example.com" && password == "password") {
//                _state.value = _state.value.copy(isLoading = false, success = true)
//            } else {
//                _state.value = _state.value.copy(
//                    isLoading = false,
//                    error = "Invalid credentials"
//                )
//            }
//        }
        //for real login
        viewModelScope.launch {
            //Request Params
            //{"expiresInMins":30,"username":"emilys","password":"emilyspass"}
            _state.value = _state.value.copy(
                isLoading = true,
                error = null,
                success = false // <-- Reset success before making new request
            )
            try {
                val request = LoginRequest(email, password, 30)
                val response = RetrofitInstance.api.login(request)
                if (response.isSuccessful && response.body() != null) {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        success = true,
                        error = null
                    )
                } else {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = response.errorBody()?.string() ?: "Login failed"
                    )
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = "Exception: ${e.message}"
                )
            }
        }
    }
}
