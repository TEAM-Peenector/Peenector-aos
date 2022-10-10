package com.example.peenector.presentation.main

import android.util.Log
import  android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_recycler_item.view.*

//커스텀 뷰홀더
class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val TAG: String = "로그"
    private var nameTextView = itemView.tv_main_name
    private var majorTextView = itemView.tv_main_major

    //기본 생성자
    init{
        Log.d(TAG,"MainViewHolder - init() called")
    }

    //데이터와 뷰를 묶는다.
    fun bind(mainModel : MainModel){
        Log.d(TAG,"MainViewHolder -bind() called")
        nameTextView.text = mainModel.name
        majorTextView.text = mainModel.major


    }


}