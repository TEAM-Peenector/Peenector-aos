package com.example.peenector.data.remote.request

data class RequestSignUp(
    val contact: String,
    val email: String,
    val name: String,
    val password: String,
    val schoolNumber: String
)