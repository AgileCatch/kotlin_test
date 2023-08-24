package com.example.frgment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.frgment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //버튼을 눌러 프래그먼트가 전환되도록 구현
        binding.apply {
            button.setOnClickListener {
                setFragment(FirstFragment())
            }
            button2.setOnClickListener {
                setFragment(SecondFragment())
            }
        }
        //버튼을 누르기전에 시작화면에 첫번째프래그먼트 화면을띄워줌
        setFragment(FirstFragment())
    }

    //inflate()함수를 통해서 fragment_first.xml 파일로부터 레이아웃을 로드
    private fun setFragment(frag: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frameLayout, frag)
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }
}