package com.example.projetkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.projetkotlin.Navigation.AppNavHost
import com.example.projetkotlin.ui.theme.ProjetKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjetKotlinTheme {
                AppNavHost()
            }
        }
    }
}