package com.example.apple_market1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apple_market1.databinding.ItemProductBinding

class ProductAdapter(var productList: ArrayList<ProductData>) :
    RecyclerView.Adapter<ProductAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    interface ItemLongClick{
        fun onLongClick(view: View, position: Int)
    }


    var itemClick: ItemClick? = null
    var itemLongClick: ItemLongClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //좋아요 버튼 클릭시 반영
        val product=productList[position]
        if (product.isliked){
            holder.isliked.setImageResource(R.drawable.heart_fill)
        }else{
            holder.isliked.setImageResource(R.drawable.heart)
        }
        holder.isliked.setOnClickListener {
            product.isliked = !product.isliked
            if (product.isliked) {
                product.like++
            } else {
                product.like--
            }

            // UI 업데이트 및 어댑터에 알림
            notifyDataSetChanged()
        }

        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }
        holder.itemView.setOnLongClickListener {  //클릭이벤트추가부분
            itemLongClick?.onLongClick(it, position)
            true
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
    fun removeItem(position: Int){
        productList.removeAt(position)
        notifyDataSetChanged()
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
        val isliked=binding.btnLike
    }
}