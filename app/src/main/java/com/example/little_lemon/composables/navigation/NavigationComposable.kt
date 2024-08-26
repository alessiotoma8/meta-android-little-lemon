package com.example.little_lemon.composables.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.little_lemon.composables.screen.Home
import com.example.little_lemon.composables.screen.Onboarding
import com.example.little_lemon.composables.screen.Profile
import com.example.little_lemon.data.cache.isUserRegister

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