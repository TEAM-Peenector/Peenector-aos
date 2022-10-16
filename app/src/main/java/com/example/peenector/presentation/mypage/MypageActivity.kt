package com.example.peenector.presentation.mypage

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.peenector.data.PennerctorClient
import com.example.peenector.data.local.MainModel
import com.example.peenector.data.remote.response.ResponseMypage
import com.example.peenector.databinding.ActivityMypageBinding
import kotlinx.android.synthetic.main.activity_mypage.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMypageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMypageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //이전페이지버튼 클릭이벤트리스너
        iv_mypage_arrow.setOnClickListener {
            finish()
        }
    }

//    private fun writeInitNetwork(id: Int) {
//        val call: Call<MainModel> = PennerctorClient.mypageService.getMypage(id)
//        call.enqueue(object : Callback<ResponseMypage> {
//            override fun onResponse(
//                call: Call<ResponseMypage>,
//                response: Response<ResponseMypage>
//            ) {
//                if (response.isSuccessful) {
//                    val data = response.body()?.data
//
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseMypage>, t: Throwable) {
//                Log.e("Mypage 서버연결", "onFailure: $t")
//            }
//        })
//    }
}