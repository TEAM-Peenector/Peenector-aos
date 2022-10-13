package com.example.peenector.data.remote.response

data class ResponseLogin(
    val statusCode: String,
    val message: String,
    val data: Data
) {
    data class Data(
        val schoolNumber: String,
        val teamNumber: String
    )
}
