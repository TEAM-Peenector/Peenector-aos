package com.example.peenector.data.remote.api

import com.example.peenector.data.local.ResponseMainData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MainTeamService {

    @GET("team/{id}")
    fun getTeam(
        @Path("id") id: Int
    ): Call<ResponseMainData>
}