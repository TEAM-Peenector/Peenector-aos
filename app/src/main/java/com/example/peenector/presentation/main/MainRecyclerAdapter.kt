package com.example.peenector.presentation.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peenector.R

class MainRecyclerAdapter : RecyclerView.Adapter<MainViewHolder>(){

    val TAG: String = "로그"
    private var modelList = ArrayList<MainModel>()

    //목록 item 수
    override fun getItemCount(): Int {
        return 10
    }

    //뷰홀더가 생성 되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        //연결할 레이아웃 설정
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item,parent,false))
    }

    //뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        Log.d(TAG, "MainRecyclerAdapter - onBindViewHolder() called / position : $position")
        holder.bind(this.modelList[position])
        //클릭 리스너 설정
        holder.itemView.setOnClickListener{
        }
    }

    //외부에서 데이터 넘기기
    fun submitList(modelList: ArrayList<MainModel>){
        this.modelList = modelList
    }
}