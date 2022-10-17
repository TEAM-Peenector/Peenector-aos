package com.example.peenector.presentation.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.peenector.MainActivity
import com.example.peenector.data.PennerctorClient
import com.example.peenector.data.remote.response.ResponseMypage
import com.example.peenector.databinding.ActivityMainTeamBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainTeamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainTeamBinding

//    private var myId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        writeInitNetwork(intentId())
        clickBack()
    }

    private fun intentId(): Int {
        return intent.getIntExtra("id", -1)
    }
    private fun clickBack(){
        binding.ivMypageArrow.setOnClickListener {
            finish()
        }
    }

    private fun writeInitNetwork(id: Int) {
        val call: Call<ResponseMypage> = PennerctorClient.mypageService.getMypage(id)
        call.enqueue(object : Callback<ResponseMypage> {
            override fun onResponse(
                call: Call<ResponseMypage>,
                response: Response<ResponseMypage>
            ) {
                if (response.isSuccessful) {
                    Log.d("mypageActivity", "onResponse: ${response.body()}")
                    binding.mydata = response.body()?.data
                } else {
                    Log.e("Mypage SuccesNO", "onResponse: ")
                }
            }

            override fun onFailure(call: Call<ResponseMypage>, t: Throwable) {
                Log.e("mypageActivity", "onFailure: ")
            }
        })
    }
}