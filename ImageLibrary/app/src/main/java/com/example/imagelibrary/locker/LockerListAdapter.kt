package com.example.imagelibrary.locker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.imagelibrary.databinding.LockerItemBinding

class LockerListAdapter : ListAdapter<LockerModel, LockerListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<LockerModel>() {
        override fun areItemsTheSame(
            oldItem: LockerModel, newItem: LockerModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: LockerModel,
            newItem: LockerModel
        ): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int, ):ViewHolder {
        return ViewHolder(
            LockerItemBinding.inflate(LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position) // ListAdapter의 메소드 getItem
        holder.bind(item)
    }

    class ViewHolder(
        private val binding: LockerItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LockerModel)= with(binding){
//이미지, 추가해야함
            binding.tvDate.text=item.date
            binding.tvTitle.text=item.name
        }

    }


}