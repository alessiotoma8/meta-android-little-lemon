package com.example.little_lemon.composables.screen

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.little_lemon.composables.Header
import com.example.little_lemon.composables.UserDataRow
import com.example.little_lemon.composables.YellowButton
import com.example.little_lemon.data.cache.clearUserData
import com.example.little_lemon.data.cache.getUserEmail
import com.example.little_lemon.data.cache.getUserLastName
import com.example.little_lemon.data.cache.getUsername
import com.example.little_lemon.composables.navigation.Home
import com.example.little_lemon.composables.navigation.Onboarding
import com.example.little_lemon.ui.theme.LittleLemonTheme


@Composable
fun Profile(context: Context, navController: NavHostController) {

    val name = context.getUsername()
    val lastName = context.getUserLastName()
    val email = context.getUserEmail()

    Column(Modifier.fillMaxSize()) {
        Header(isUserLogged = true)

        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            Text(
                text = "Personal Information",
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h3
            )

            UserDataRow(
                label = "First Name",
                value = name,
                onValueChange = {},
                canEdit = false
            )

            UserDataRow(
                label = "Last Name",
                value = lastName,
                onValueChange = {},
                canEdit = false
            )

            UserDataRow(
                label = "Email",
                value = email,
                onValueChange = {},
                canEdit = false
            )
        }

        YellowButton(
            modifier = Modifier.padding(padding),
            label = "Logout",
            onClick = {
                context.clearUserData()
                navController.navigate(Onboarding.route) {
                    popUpTo(Home.route) { inclusive = true }
                    launchSingleTop = true
                }
            }
        )
    }
}

@Composable
@Preview
fun ProfilePreview() {
    LittleLemonTheme {
        Surface {
            Profile(context = LocalContext.current, navController = rememberNavController())
        }
    }
}