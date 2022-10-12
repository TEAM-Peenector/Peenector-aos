package com.example.peenector

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.peenector.databinding.ActivityMainBinding
import com.example.peenector.presentation.main.MainModel
import com.example.peenector.presentation.main.MainRecyclerAdapter
import com.example.peenector.presentation.mission.MissionActivity
import com.example.peenector.presentation.mypage.MypageActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val TAG: String = "로그"

    //데이터를 담을 그릇 즉 배열
    var modelList = ArrayList<MainModel>()

    private lateinit var mainRecyclerAdapter: MainRecyclerAdapter

    //뷰가 화면에 그려질때
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG,"MainActivity - onCreate() called")

        //8번 반복한다.
        for(i in 1..8){
            var mainModel = MainModel(name = "홍길동 $i",major ="컴퓨터공학과")
            this.modelList.add(mainModel)
       }
        Log.d(TAG,"MainActivity - 반복문 돌린 후 this.modelList.size : $(this.modelList.size)")

        //어답터 인스턴스 생성
        mainRecyclerAdapter = MainRecyclerAdapter()

        mainRecyclerAdapter.submitList(this.modelList)

        //리사이클러뷰 설정
        my_recycler_view.apply{
            val gridLayoutManager = GridLayoutManager(this@MainActivity,2)
            layoutManager = gridLayoutManager

            //어답터 장착
            adapter = mainRecyclerAdapter
        }

        //마이페이지버튼 클릭이벤트리스너
        btn_main_mypage.setOnClickListener{
            var intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
        }
        //미션페이지버튼 클릭이벤트리스너
        btn_main_missionpage.setOnClickListener{
            var intent = Intent(this,MissionActivity::class.java)
            startActivity(intent)
        }
    }
}