package com.example.peenector.data.remote.api

import com.example.peenector.data.remote.request.RequestMatchingTeam
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MainService {
    @GET("team/{teamId}")
    fun getMain(
        @Path("teamId") teamId : String
    ): Call<RequestMatchingTeam>
}