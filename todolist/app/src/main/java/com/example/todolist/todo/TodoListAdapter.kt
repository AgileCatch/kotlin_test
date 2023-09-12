package com.example.todolist.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.BookmarkItemBinding

class TodoListAdapter : RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {
    private val list = ArrayList<TodoModel>()

    fun addItems(items: ArrayList<TodoModel>) {
        list.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListAdapter.ViewHolder {
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
        fun bind(item: TodoModel){
            binding.title.text=item.title
        }

    }
}