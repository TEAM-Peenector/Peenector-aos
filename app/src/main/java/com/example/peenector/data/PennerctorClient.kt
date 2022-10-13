package com.example.peenector.data

import com.example.peenector.data.remote.api.LoginService
import com.example.peenector.data.remote.api.SignUpService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


object PennerctorClient {
    private const val BASE_URL = "http://43.201.97.88:8080/v1/"

    private val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient(AppInterceptor()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val loginService: LoginService = retrofit.create(LoginService::class.java)
    val signUpService: SignUpService = retrofit.create(SignUpService::class.java)

}

private fun provideOkHttpClient(interceptor: AppInterceptor): OkHttpClient =
    OkHttpClient.Builder().run {
        addInterceptor(interceptor)
        build()
    }

class AppInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val newRequest = request().newBuilder()
            .addHeader("userId", "1")
            .build()
        proceed(newRequest)
    }
}