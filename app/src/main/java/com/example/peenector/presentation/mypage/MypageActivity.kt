package com.example.peenector.presentation.mypage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.peenector.MainActivity
import com.example.peenector.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_mypage.*

class MypageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        //이전페이지버튼 클릭이벤트리스너
        iv_mypage_arrow.setOnClickListener{
            finish()
        }
    }
}