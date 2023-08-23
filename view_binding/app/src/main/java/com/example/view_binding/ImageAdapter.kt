package com.example.view_binding

import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter :BaseAdapter(){
    //항목의 총 개수를 반환하기 위해 catIds 배열의 크기를 반환
    override fun getCount(): Int {
        return catIds.size
    }

    //특정 위치의 항목을 반환하기 위해 catIds 배열의 지정된 위치의 항목을 반환
    override fun getItem(position: Int): Any {
        return catIds[position]
    }

    //특정 위치의 항목 아이디를 반환하는 것인데, 여기서는 배열의 위치(순서)를 항목의 아이디로 간주함
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //getView 메소드는 첫번째 파라미터로 주어진 위치의 항목 뷰를 반환
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView:ImageView

        //catIds배열의 position 위치에 있는 이미지 리소스를 ImageView의 이미지로 설정하고,
        // 이 설정된 ImageView 객체를 그리드 뷰의 항목뷰로 반환
        if (convertView==null){
            imageView= ImageView(parent!!.context)
            imageView.layoutParams=AbsListView.LayoutParams(200,200)
            //CENTER_CROP은 종횡비를 유지하여 스케일링하며 뷰의 크기 이상으로 채우게 됨을 의미한다. 따라서 이미지 일부가 잘릴 수 있다.
            imageView.scaleType=ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8,8,8,8,)
        }else{
            //convertView는 이전에 생성된 항목뷰 (여기서는 ImageView)를 의미
            //새로운 이미지뷰 객체를 만들고 크기와 스케일타입, 패팅을 설정한다.
            // 만약 이전에 이미 만들어진 것이라면, 이를 재사용 한다.
            imageView = convertView as ImageView
        }
        imageView.setImageResource(catIds.get(position))
        return imageView
    }

    //ImageAdapter가 관리하는 데이터는 편의상 직접 ImageAdapter 내부에 Image 리소스 ID의 배열로 설정
    private val catIds = arrayOf<Int>(
        R.drawable.cat1,
        R.drawable.cat2,
        R.drawable.cat3,
        R.drawable.cat4,
        R.drawable.cat5,
        R.drawable.cat6,
        R.drawable.cat7,
        R.drawable.cat8,
        R.drawable.cat1,
        R.drawable.cat2,
        R.drawable.cat3,
        R.drawable.cat4,
        R.drawable.cat5,
        R.drawable.cat6,
        R.drawable.cat7,
        R.drawable.cat8,

    )
}