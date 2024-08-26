package com.example.little_lemon.domain

fun checkUserRegistration(name:String,lastName:String,email:String): Boolean {
    return name.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()
}