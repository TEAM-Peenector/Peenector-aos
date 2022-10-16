package com.example.peenector.data.remote.response

data class ResponseTeam(
    val statusCode: String,
    val message: String,
    val data: Data
) {
    data class Data(
        val major: String,
        val studentName: String,
        val id: Int
    )
}
