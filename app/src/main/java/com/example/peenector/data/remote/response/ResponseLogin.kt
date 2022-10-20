package com.example.peenector.data.remote.response

data class ResponseLogin(
    val statusCode: String,
    val message: String,
    val data: Data
) {
    data class Data(
        val id: Int,
        val schoolNumber: String,
        val teamNumber: Int
    )
}
