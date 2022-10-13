package com.example.peenector.data.remote.api

import com.example.peenector.data.remote.request.RequestLogin
import com.example.peenector.data.remote.response.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    //로그인
    @POST("login")
    fun postLogin(
        @Body body: RequestLogin
    ): Call<ResponseLogin>

}