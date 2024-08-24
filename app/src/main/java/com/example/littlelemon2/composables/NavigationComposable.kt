package com.example.littlelemon2.composables

import SKK.littlelemon.Data.MenuViewModel
import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon2.data.cache.isUserRegister
import com.example.littlelemon2.destination.Home
import com.example.littlelemon2.destination.Onboarding
import com.example.littlelemon2.destination.Profile
import io.ktor.http.ContentType

@Composable
fun NavigationComposable(
    context: Context,
    navController: NavHostController,
) {

    val isUserRegister = context.isUserRegister()
    val startDestination = if (isUserRegister) Home.route else Onboarding.route

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Onboarding.route) {
            Onboarding(context = context, navController = navController)
        }
        composable(Home.route) {
            Home(navController = navController)
        }
        composable(Profile.route) {
            Profile(context = context, navController = navController)
        }
    }
}