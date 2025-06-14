package com.example.mviarchitecturelogin.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("username") val mobileNo: String,
    @SerializedName("password") val password: String,
    @SerializedName("expiresInMins") val expiresInMins: Int
)
