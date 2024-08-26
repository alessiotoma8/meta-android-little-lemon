package com.example.little_lemon.data.cache

import android.content.Context
import android.content.SharedPreferences


private fun Context.getUserPreference(): SharedPreferences = getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)

fun Context.isUserRegister() = getUserPreference().getBoolean("isUserRegister", false)
private fun Context.saveUserRegister(isRegister:Boolean) = getUserPreference().edit().putBoolean("isUserRegister", isRegister).apply()

fun Context.saveUser(
    name: String,
    lastName: String,
    email: String
) {
    getUserPreference().edit().apply {
        putString("name", name)
        putString("lastName", lastName)
        putString("email", email)
    }.apply()
    saveUserRegister(true)
}

fun Context.clearUserData() {
    getUserPreference().edit().clear().apply()
}

fun Context.getUsername() = getUserPreference().getString("name", "")?:""
fun Context.getUserLastName() = getUserPreference().getString("lastName", "")?:""
fun Context.getUserEmail() = getUserPreference().getString("email", "")?:""