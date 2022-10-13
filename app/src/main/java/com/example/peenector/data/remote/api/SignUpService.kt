package com.example.peenector.data.remote.api

import com.example.peenector.data.remote.request.RequestSignUp
import com.example.peenector.data.remote.response.ResponseSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    //로그인
    @POST("signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>

}