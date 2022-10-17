package com.example.peenector.data.local

data class ResponseMainData(
    val statusCode: String,
    val message: String,
    val data: ArrayList<MainModel>
)
