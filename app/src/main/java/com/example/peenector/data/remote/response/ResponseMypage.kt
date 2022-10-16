package com.example.peenector.data.remote.response

import com.example.peenector.data.local.MypageData

data class ResponseMypage(
    val statusCode: String,
    val message: String,
    val data: MypageData
)
