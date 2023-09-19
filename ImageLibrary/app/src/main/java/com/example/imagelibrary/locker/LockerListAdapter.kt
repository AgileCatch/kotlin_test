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

    private val list = ArrayList<LockerModel>()
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int, ):ViewHolder {
        return ViewHolder(
            LockerItemBinding.inflate(LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position] // ListAdapter의 메소드 getItem
        holder.bind(item)
    }

    class ViewHolder(
        private val binding: LockerItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LockerModel)= with(binding){
//이미지, 추가해야함
            binding.tvDate.text=item.date
            binding.tvName.text=item.name
        }

    }

    fun addItems(items: List<LockerModel>) {
        list.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

}