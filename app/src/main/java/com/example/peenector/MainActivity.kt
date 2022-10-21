package com.example.peenector

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.peenector.data.PennerctorClient
import com.example.peenector.data.local.ResponseMainData
import com.example.peenector.databinding.ActivityMainBinding
import com.example.peenector.presentation.main.MainRecyclerAdapter
import com.example.peenector.presentation.main.MainTeamActivity
import com.example.peenector.presentation.mission.MissionActivity
import com.example.peenector.presentation.mypage.MypageActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //    var teamId: Int = -1
    private lateinit var mainRecyclerAdapter: MainRecyclerAdapter

    //뷰가 화면에 그려질때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainRecyclerAdapter = MainRecyclerAdapter(this) { itemClick(it) }

        //리사이클러뷰 설정
        my_recycler_view.apply {
            val gridLayoutManager = GridLayoutManager(this@MainActivity, 2)
            layoutManager = gridLayoutManager
            //어답터 장착
            adapter = mainRecyclerAdapter
        }

        writeInitNetwork(getIntentTeamId())
        clickBtn(getUserId())
    }

    private fun itemClick(id: Int) {
        val intent = Intent(this, MainTeamActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

    private fun getIntentTeamId(): Int {
        return intent.getIntExtra("id", -1)
//        Log.d("getIntentTeamId", "clickBtn: $")
    }

    private fun getUserId(): Int {
        return intent.getIntExtra("userId", -1)
    }

//    private fun initID(mainModel: MainModel) {
//        mainModel.id
//    }


    private fun clickBtn(id: Int) {
        //마이페이지버튼 클릭이벤트리스너
        btn_main_mypage.setOnClickListener {
            val intent = Intent(this, MypageActivity::class.java)
            intent.putExtra("userId", id)
            startActivity(intent)
        }
        //미션페이지버튼 클릭이벤트리스너
        btn_main_missionpage.setOnClickListener {
            val intent = Intent(this, MissionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun writeInitNetwork(id: Int) {
        val call: Call<ResponseMainData> = PennerctorClient.mainTeamService.getTeam(id)
        call.enqueue(object : Callback<ResponseMainData> {
            override fun onResponse(
                call: Call<ResponseMainData>,
                response: Response<ResponseMainData>
            ) {
                if (response.isSuccessful) {
                    Log.d("mainActivity", "onResponse: ${response.body()}")
                    response.body()?.let { mainRecyclerAdapter.submitList(it.data) }
                } else {
                    Log.e("Mainactivity SuccesNO", "onResponse: ")
                }
            }

            override fun onFailure(call: Call<ResponseMainData>, t: Throwable) {
                Log.e("mainActivityOnFail", "onFailure: ")
            }


        })
    }

}
