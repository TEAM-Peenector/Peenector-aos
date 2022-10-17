package com.example.peenector.presentation.main

import androidx.recyclerview.widget.RecyclerView
import com.example.peenector.data.local.MainModel
import com.example.peenector.databinding.ItemListMainBinding

//커스텀 뷰홀더
class MainViewHolder(
    private val binding: ItemListMainBinding,
    private val itemClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    //데이터와 뷰를 묶는다.
    fun bind(data: MainModel) {
        binding.mainModel = data
        binding.root.setOnClickListener {
            itemClick(data.id)
        }
    }
}

