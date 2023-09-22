package com.example.imagelibrary.searchresults.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagelibrary.R
import com.example.imagelibrary.databinding.SearchItemBinding


class SearchListAdapter(
    private val onLikeChecked: (SearchModel, Int) -> Unit
): ListAdapter<SearchModel, SearchListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<SearchModel>() {
        override fun areItemsTheSame(
            oldItem: SearchModel, newItem: SearchModel
        ): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(
            oldItem: SearchModel,
            newItem: SearchModel
        ): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SearchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),
            onLikeChecked
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(
        private val binding: SearchItemBinding,
        private val onLikeChecked: (SearchModel, Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SearchModel)= with(binding){
            Glide.with(itemView).load(item.url)
                .placeholder(R.drawable.ic_cat) // 이미지 로딩 중 사진
                .error(R.drawable.icon_block) // 이미지를 불러오지 못했을 때 사진
                .into(imageView)
            tvDate.text=item.dateTime
            tvTitle.text=item.title

            //버튼 클릭시 북마크처리
            btnLike.isSelected = item.isLiked

            btnLike.setOnClickListener {
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