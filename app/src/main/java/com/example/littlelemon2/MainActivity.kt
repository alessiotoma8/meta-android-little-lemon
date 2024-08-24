package com.example.littlelemon2

import SKK.littlelemon.Data.MenuViewModel
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon2.composables.NavigationComposable
import com.example.littlelemon2.data.network.Network
import com.example.littlelemon2.data.toMenuItemRoom
import com.example.littlelemon2.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json



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

