package com.example.todolist.bookmark

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.BookmarkItemBinding

class BookMarkListAdapter : RecyclerView.Adapter<BookMarkListAdapter.ViewHolder>() {
    private val list = ArrayList<BookMarkModel>()

    fun addItems(items: ArrayList<BookMarkModel>) {
        list.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookMarkListAdapter.ViewHolder {
        return ViewHolder(
            BookmarkItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
        private val binding: BookmarkItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BookMarkModel){
            binding.title.text=item.title
        }

    }
}