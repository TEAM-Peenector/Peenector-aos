package com.example.peenector.data.remote.api

import com.example.peenector.data.remote.request.RequestMatchingTeam
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileService {
    @GET("student/{id}")
    fun getMain(
        @Path("id") id : Int
    ): Call<RequestMatchingTeam>
}