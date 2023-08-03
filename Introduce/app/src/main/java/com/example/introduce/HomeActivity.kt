package com.example.introduce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {

    private val imageArray = arrayOf(
        R.drawable.cat2,
        R.drawable.cat3,
        R.drawable.cat4,
        R.drawable.cat5,
        R.drawable.dog,

        // 여기에 추가적으로 랜덤으로 가져올 이미지 리소스 ID를 추가합니다.
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //랜덤사진 설정하기
        val homeImage = findViewById<ImageView>(R.id.homeImage)
        // 랜덤 숫자를 생성하여 이미지 배열에서 해당 인덱스의 이미지를 선택합니다.
        val randomIndex = Random.nextInt(imageArray.size)
        val randomImage = imageArray[randomIndex]
        homeImage.setImageResource(randomImage)

        //데이터 받아오기
        val data_name =intent.getStringExtra("name Data")
        val data_id =intent.getStringExtra("id Data")
        val data_age=intent.getStringExtra("age Data")
        val data_mbti=intent.getStringExtra("mbti Data")

        val homeName=findViewById<TextView>(R.id.homeName)
        val homeId=findViewById<TextView>(R.id.homeId)
        val homeAge=findViewById<TextView>(R.id.homeAge)
        val homeMBTI=findViewById<TextView>(R.id.homeMBTI)

        homeName.setText(data_name)
        homeId.setText(data_id)
        homeAge.setText(data_age)
        homeMBTI.setText(data_mbti)


        //화면 종료
        val btn_close=findViewById<Button>(R.id.close)
        btn_close.setOnClickListener {
            finish()
        }
    }
}