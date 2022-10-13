package com.example.peenector.data.remote.response

data class ResponseSignUp(
    val statusCode: String,
    val message: String,
    val data: Data
) {
    data class Data(
        val id: Int,
        val teamId: Int
    )
}
