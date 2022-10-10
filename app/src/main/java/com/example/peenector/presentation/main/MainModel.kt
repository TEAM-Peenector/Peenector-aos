package com.example.peenector.presentation.main

import android.util.Log

class MainModel(var name: String? = null, var major:String?  = null) {
    val TAG: String = "로그"
    //기본 생성자
    init{
        Log.d(TAG,"MainModel - init() called")
    }
}