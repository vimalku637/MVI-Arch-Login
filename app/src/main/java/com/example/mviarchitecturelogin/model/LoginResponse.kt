package com.example.mviarchitecturelogin.model

data class LoginResponse(
    val status: String,
    val message: String,
    val token: String? // Add fields as per your API
)

