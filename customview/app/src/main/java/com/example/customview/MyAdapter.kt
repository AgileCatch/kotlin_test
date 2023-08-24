package com.example.customview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(val mContext: Context, val mItems: MutableList<MyItem>) : BaseAdapter() {

    // MyAdapter 클래스가 관리하는 항목의 총 개수를 반환
    override fun getCount(): Int {
        return mItems.size
    }

    // MyAdapter 클래스가 관리하는 항목의 중에서 position 위치의 항목을 반환
    override fun getItem(position: Int): Any {
        return mItems[position]
    }

    // 항목 id를 항목의 위치로 간주함
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // position 위치의 항목에 해당되는 항목뷰를 반환하는 것이 목적임
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertView = convertView
        if (convertView == null) convertView = LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)

        val item : MyItem = mItems[position]

        // convertView 변수로 참조되는 항목 뷰 객체내에 포함된 객체를 id를 통해 얻어옴
        val iconImageView = convertView?.findViewById<View>(R.id.iv_cat) as ImageView
        val tv_name = convertView.findViewById<View>(R.id.tv_name) as TextView
        val tv_age = convertView.findViewById<View>(R.id.tv_age) as TextView

        // 어댑터가 관리하는 항목 데이터 중에서 position 위치의 항목의 객체를 헤딩 힝목에 설정
        iconImageView.setImageResource(item.aIcon)
        tv_name.text = item.aName
        tv_age.text = item.aAge

        return convertView
    }
}