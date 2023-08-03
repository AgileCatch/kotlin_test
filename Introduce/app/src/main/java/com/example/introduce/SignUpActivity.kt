package com.example.introduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signUpname = findViewById<EditText>(R.id.signUpName)
        val signUpId = findViewById<EditText>(R.id.signUpId)
        val signUpPw = findViewById<EditText>(R.id.signUpPw)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            val name = signUpname.text.toString().trim()
            val id = signUpId.text.toString().trim()
            val password = signUpPw.text.toString().trim()

            if (id.isEmpty() || password.isEmpty() || name.isEmpty()) {
                // 아이디 또는 비밀번호가 비어있는 경우
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                // 로그인 성공
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()

                //SignUp 데이터를 SignIn 으로 전달
                val edit_name=findViewById<EditText>(R.id.signUpName)
                val edit_id=findViewById<EditText>(R.id.signUpId)
                val edit_pw=findViewById<EditText>(R.id.signUpPw)
                val edit_age=findViewById<EditText>(R.id.signUpAge)
                val edit_mbti=findViewById<EditText>(R.id.signUpMBTI)

                val data_name =edit_name.text.toString()
                val data_id =edit_id.text.toString()
                val data_pw=edit_pw.text.toString()
                val data_age=edit_age.text.toString()
                val data_mbti=edit_mbti.text.toString()

                val intent = Intent(this,SignInActivity::class.java)
                intent.putExtra("name Data",data_name)
                intent.putExtra("id Data",data_id)
                intent.putExtra("pw Data",data_pw)
                intent.putExtra("age Data",data_age)
                intent.putExtra("mbti Data",data_mbti)
                startActivity(intent)

                // SignIn화면으로 전환
                finish()
            }
        }
    }


}