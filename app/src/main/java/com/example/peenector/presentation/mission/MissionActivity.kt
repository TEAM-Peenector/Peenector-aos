package com.example.peenector.presentation.mission

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.peenector.R
import com.example.peenector.presentation.mypage.MypageActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_mission.*

class MissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mission)

        //마이페이지버튼 클릭이벤트리스너
        btn_mission_mypage.setOnClickListener {
            var intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
        }
    }
}