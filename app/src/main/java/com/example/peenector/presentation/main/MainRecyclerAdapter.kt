package com.example.peenector.presentation.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peenector.data.local.MainModel
import com.example.peenector.databinding.ItemListMainBinding

class MainRecyclerAdapter(context: Context, private val itemClick: (Int) -> Unit) :
    RecyclerView.Adapter<MainViewHolder>() {
    private var modelList: List<MainModel> = emptyList()
    private val layoutInflater by lazy { LayoutInflater.from(context) }

    //뷰홀더가 생성 되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        //연결할 레이아웃 설정
        val binding = ItemListMainBinding.inflate(layoutInflater, parent, false)

        return MainViewHolder(binding, itemClick)
    }

    //뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(this.modelList[position])
        Log.d("onBind확인", "submitList: $this.modelList")
    }

//    private fun idInt(data:) {
//
//    }

    //외부에서 데이터 넘기기
    fun submitList(modelList: List<MainModel>) {
        this.modelList = modelList
        notifyDataSetChanged()
//        Log.d("submitList확인", "submitList: $modelList")
    }

    //목록 item 수
    override fun getItemCount(): Int = modelList.size

}