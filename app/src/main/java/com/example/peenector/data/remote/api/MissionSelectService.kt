package com.example.peenector.data.remote.api

import com.example.peenector.data.remote.request.RequestMatchingTeam
import com.example.peenector.data.remote.request.RequestMissionSelect
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MissionSelectService {
    @GET("team/teamId/mission")
    fun getMain(
        @Path("mission") mission : Int
    ): Call<RequestMissionSelect>
}