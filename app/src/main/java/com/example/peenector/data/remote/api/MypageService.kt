package com.example.peenector.data.remote.api

import com.example.peenector.data.remote.response.ResponseMypage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MypageService {
    @GET("student/{id}")
    fun getMypage(
        @Path("id") id: Int
    ): Call<ResponseMypage>
}