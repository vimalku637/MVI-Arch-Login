package com.example.mviarchitecturelogin.intent

sealed class LoginIntent {
    data class EnterEmail(val email: String) : LoginIntent()
    data class EnterPassword(val password: String) : LoginIntent()
    object Submit : LoginIntent()
}