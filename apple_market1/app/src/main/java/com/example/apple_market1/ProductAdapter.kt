package com.example.apple_market1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apple_market1.databinding.ItemProductBinding

class ProductAdapter(var productList: ArrayList<ProductData>) :
    RecyclerView.Adapter<ProductAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }
        holder.productImg.setImageResource(productList[position].productImg)
        holder.productName.text = productList[position].productName
        holder.price.text = formatPrice(productList[position].price)
        holder.address.text = productList[position].address
        holder.like.text = productList[position].like.toString()
        holder.chat.text = productList[position].chat.toString()
    }

    fun getItem(position: Int): ProductData {
        return productList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class Holder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        val productImg = binding.ivProductImg
        val productName = binding.tvProductName
        val price = binding.tvPrice
        val address = binding.tvAddress
        val like = binding.tvLike
        val chat = binding.tvChat
    }
}