package com.example.viewbinding

import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdaptor : BaseAdapter() {

    private val mThumbIds = arrayOf<Int>(
        R.drawable.cat1, R.drawable.cat2,
        R.drawable.cat3, R.drawable.cat4,
        R.drawable.cat5, R.drawable.cat6,
        R.drawable.cat7, R.drawable.cat8,
        R.drawable.cat9, R.drawable.cat1,
        R.drawable.cat2, R.drawable.cat3,
        R.drawable.cat4, R.drawable.cat5,
        R.drawable.cat6, R.drawable.cat7,
        R.drawable.cat8, R.drawable.cat9
    )

    override fun getCount(): Int {
        return mThumbIds.size
    }

    override fun getItem(position: Int): Any {
        return mThumbIds[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null) {
            imageView = ImageView(parent!!.context)
            imageView.layoutParams = AbsListView.LayoutParams(340, 340)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(10, 10, 10, 10)
        } else {
            imageView = convertView as ImageView
        }

        imageView.setImageResource(mThumbIds.get(position))
        return imageView
    }
}