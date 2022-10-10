package com.example.peenector

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peenector.databinding.ActivityMainBinding
import com.example.peenector.presentation.main.MainModel
import com.example.peenector.presentation.main.MainRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val TAG: String = "로그"

    //데이터를 담을 그릇 즉 배열
    var modelList = ArrayList<MainModel>()

    private lateinit var mainRecyclerAdapter: MainRecyclerAdapter

    //뷰가 화면에 그려질때때
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG,"MainActivity - onCreate() called")

        //10번 반복한다.
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
    }
}