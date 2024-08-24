package com.example.littlelemon2.data

fun checkUserRegistration(name:String,lastName:String,email:String): Boolean {
    return name.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()
}