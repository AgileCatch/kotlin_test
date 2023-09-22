package com.example.imagelibrary.locker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagelibrary.R
import com.example.imagelibrary.databinding.LockerItemBinding


class LockerListAdapter(
    private val onLikeChecked: ( LockerModel, Int) -> Unit
): ListAdapter<LockerModel, LockerListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<LockerModel>() {
        override fun areItemsTheSame(
            oldItem: LockerModel, newItem: LockerModel
        ): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(
            oldItem: LockerModel,
            newItem: LockerModel
        ): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LockerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),
            onLikeChecked
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(
        private val binding: LockerItemBinding,
        private val onLikeChecked: ( LockerModel, Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LockerModel)= with(binding){
            Glide.with(itemView).load(item.url)
                .placeholder(R.drawable.ic_cat) // 이미지 로딩 중 사진
                .error(R.drawable.icon_block) // 이미지를 불러오지 못했을 때 사진
                .into(imageView)
            tvDate.text=item.dateTime
            tvTitle.text=item.title

            btnLike.setOnClickListener { isSelected ->
                onLikeChecked(
                    item.copy(
                        isLiked = !item.isLiked
                    ),
                    adapterPosition
                )
            }

        }

    }


}