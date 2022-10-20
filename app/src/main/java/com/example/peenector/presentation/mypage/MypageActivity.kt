package com.example.peenector.presentation.mypage

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.peenector.data.PennerctorClient
import com.example.peenector.data.remote.response.ResponseMypage
import com.example.peenector.databinding.ActivityMypageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMypageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMypageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        writeInitNetwork(intentId())
        clickBack()
    }

    private fun intentId(): Int {
        return intent.getIntExtra("userId", -1)
    }

    private fun clickBack() {
        binding.ivMypageArrow.setOnClickListener {
            finish()
        }
    }


    private fun writeInitNetwork(id: Int) {
        val call: Call<ResponseMypage> = PennerctorClient.mypageService.getMypage(id)
        Log.d("mypageService check Id", "writeInitNetwork: $id")
        call.enqueue(object : Callback<ResponseMypage> {
            override fun onResponse(
                call: Call<ResponseMypage>,
                response: Response<ResponseMypage>
            ) {
                if (response.isSuccessful) {
                    Log.d("mypageActivity", "onResponse: ${response.body()}")
                    binding.mydata = response.body()?.data
                } else {
                    Log.e("mypage SuccesNO", "onResponse: ")
                }
            }

            override fun onFailure(call: Call<ResponseMypage>, t: Throwable) {
                Log.e("mypageActivity", "onFailure: ")
            }
        })
    }
}