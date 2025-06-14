package com.example.mviarchitecturelogin.retrofitApi

import com.example.mviarchitecturelogin.model.LoginRequest
import com.example.mviarchitecturelogin.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("login") // Change to your real endpoint
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}
