package com.example.littlelemon2.destination


interface Destinations{
    val route: String
}

object Onboarding: Destinations{
    override val route = "Onboarding"
}

object Home: Destinations{
    override val route = "Home"
}

object Profile: Destinations{
    override val route = "Profile"
}