package com.example.little_lemon.composables.screen

import android.content.Context
import android.widget.Toast
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.little_lemon.composables.Header
import com.example.little_lemon.composables.InfoCard
import com.example.little_lemon.composables.UserDataRow
import com.example.little_lemon.composables.YellowButton
import com.example.little_lemon.data.cache.saveUser
import com.example.little_lemon.domain.checkUserRegistration
import com.example.little_lemon.composables.navigation.Home
import com.example.little_lemon.composables.navigation.Onboarding
import com.example.little_lemon.ui.theme.LittleLemonTheme

val padding = 20.dp
val spacing = 28.dp

@Composable
fun Onboarding(context: Context, navController: NavController) {

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    Column(Modifier.fillMaxSize()) {
        Header(isUserLogged = false)

        Column(
            Modifier
                .fillMaxSize()
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            InfoCard(
                subtitle = "Let's get to know you"
            )

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(padding),
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
                    value = firstName,
                    onValueChange = { firstName = it }
                )

                UserDataRow(
                    label = "Last Name",
                    value = lastName,
                    onValueChange = { lastName = it }
                )

                UserDataRow(
                    label = "Email",
                    value = email,
                    onValueChange = { email = it }
                )
            }
        }


        YellowButton(
            modifier = Modifier.padding(padding),
            label = "Register", onClick = {
                val isValidRegistrationData = checkUserRegistration(
                    name = firstName,
                    lastName = lastName,
                    email = email
                )
                if (!isValidRegistrationData) {
                    Toast.makeText(
                        context,
                        "Registration unsuccessful. Please enter all data.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    context.saveUser(
                        name = firstName,
                        lastName = lastName,
                        email = email
                    )
                    Toast.makeText(
                        context,
                        "Registration successful!",
                        Toast.LENGTH_SHORT
                    ).show()

                    navController.navigate(Home.route) {
                        popUpTo(Onboarding.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun OnboardingPreview() {
    LittleLemonTheme {
        Surface {
            Onboarding(context = LocalContext.current, navController = rememberNavController())
        }
    }
}