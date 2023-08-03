package com.example.introduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val idText = findViewById<EditText>(R.id.idText)
        val pwText = findViewById<EditText>(R.id.pwText)
        val signIn =findViewById<Button>(R.id.signIn)
        val signUp =findViewById<Button>(R.id.signUp)

        //데이터 받아오기
        val data_name =intent.getStringExtra("name Data")
        val data_id =intent.getStringExtra("id Data")
        val data_pw=intent.getStringExtra("pw Data")
        val data_age=intent.getStringExtra("age Data")
        val data_mbti=intent.getStringExtra("mbti Data")

        //아이디 비밀번호 자동입력
        idText.setText(data_id)
        pwText.setText(data_pw)

        signIn.setOnClickListener {
            val id = idText.text.toString().trim()
            val password = pwText.text.toString().trim()

            if (id.isEmpty() || password.isEmpty()) {
                // 아이디 또는 비밀번호가 비어있는 경우
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else if (data_id != id || data_pw!=password) {

                Toast.makeText(this, "아이디와 비번호를 다시 확인해주세요.", Toast.LENGTH_SHORT).show()
            }else if (data_id==id || data_pw==password){
                // 로그인 성공
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

                //HomeActivity로 화면전환
                val intent=Intent(this,HomeActivity::class.java)
                //데이터 넘겨주기
                intent.putExtra("name Data",data_name)
                intent.putExtra("id Data",data_id)
                intent.putExtra("pw Data",data_pw)
                intent.putExtra("age Data",data_age)
                intent.putExtra("mbti Data",data_mbti)
                startActivity(intent)
            }
        }
        //SignUpActivity화면으로 전환
        signUp.setOnClickListener {
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}