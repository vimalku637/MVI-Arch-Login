package com.example.mviarchitecturelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mviarchitecturelogin.ui.theme.MVIArchitectureLoginTheme
import com.example.mviarchitecturelogin.ui.view.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVIArchitectureLoginTheme {
                LoginScreen()
            }
        }
    }
}