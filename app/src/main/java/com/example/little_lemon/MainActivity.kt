package com.example.little_lemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.little_lemon.composables.navigation.NavigationComposable
import com.example.little_lemon.ui.theme.LittleLemonTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                Scaffold(
                    modifier = Modifier
                        .navigationBarsPadding()
                        .statusBarsPadding(),
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier.consumeWindowInsets(innerPadding),
                        color = MaterialTheme.colors.background
                    ) {
                        NavigationComposable(
                            context = applicationContext,
                            navController = rememberNavController()
                        )
                    }
                }
            }
        }
    }
}

