package com.peter.appwork_midterm.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.peter.appwork_midterm.data.ContentData
import com.peter.appwork_midterm.databinding.ItemHomeBinding

class HomeAdapter() :
    androidx.recyclerview.widget.ListAdapter<ContentData, HomeAdapter.HomeViewHolder>(HomeDiffCallBack()){

    class HomeViewHolder private constructor(val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ContentData) {
            binding.item = product
        }
        companion object {
            fun from(parent: ViewGroup): HomeViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemHomeBinding.inflate(layoutInflater, parent, false)
                return HomeViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
        }
    }



class HomeDiffCallBack : DiffUtil.ItemCallback<ContentData>() {
    override fun areItemsTheSame(oldItem: ContentData, newItem: ContentData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ContentData, newItem: ContentData): Boolean {
        return oldItem == newItem
    }

}
