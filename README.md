# Little Lemon

Little lemon is the Capstone project for Meta's Android Developer Course on Coursera made in Kotlin.

## Screenshot

| Onboarding Screen | Home Screen |
|-------------------|-------------|
| ![screenshot_on_board_screen](https://github.com/user-attachments/assets/3368e093-b806-4b7c-a0f7-f5206d9b9da3) | ![screenshot_home_screen](https://github.com/user-attachments/assets/8c97f829-08ab-43ad-84e2-7a099ac437d7) |


## Built With

**[Kotlin:](https://kotlinlang.org/)** As the programming language.

**[ktor:](https://ktor.io/)** For fetching data asynchronously from the server.

**[Jetpack Compose:](https://developer.android.com/jetpack/compose/documentation)** To make the UI.

**[Room:](https://developer.android.com/training/data-storage/room)** To cache the network data locally.

**[Glide Compose:](https://bumptech.github.io/glide/int/compose.html)** To load images asynchronously.

**[Jetpack Navigation:](https://developer.android.com/jetpack/compose/navigation)** For navigation between screens.

## Installation

Simply clone this repository and open LittleLemon folder (android project folder) in android studio. To clone:

```
  https://github.com/alessiotoma8/meta-android-little-lemon.git
```

## Architecture

This app made using Android recommended [MVVM]("https://developer.android.com/topic/architecture") Architecture. Packages and their roles:

* `data` - It is the data layer which contains class realated to database.
  * `cache` - local data base(Room)
  * `network` - REST Client
  * `util` - util functions

* `domain` - Containing business logic and use cases.

* `composables` - It is UI layer which contains composable, view-models and navigation.
  * `screen` -  Ui components containing screens for navigation destinations.
  * `navigation` - Contains navigation graph and routes.

