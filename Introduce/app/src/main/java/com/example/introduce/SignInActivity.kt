package com.example.introduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val idText = findViewById<EditText>(R.id.idText)
        val pwText = findViewById<EditText>(R.id.pwText)
        val signIn =findViewById<Button>(R.id.signIn)
        val signUp =findViewById<Button>(R.id.signUp)

        signIn.setOnClickListener {
            val id = idText.text.toString().trim()
            val password = pwText.text.toString().trim()

            if (id.isEmpty() || password.isEmpty()) {
                // 아이디 또는 비밀번호가 비어있는 경우
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                // 로그인 성공
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                //HomeActivity로 화면전환
                val intent=Intent(this,HomeActivity::class.java)
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