package com.example.dialog

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.dialog.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. 기본 다이얼로그
        binding.btn1Alert.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("기본 다이얼로그 타이틀")
            builder.setMessage("기본 다이얼로그 메세지")
            builder.setIcon(R.mipmap.ic_launcher)

            // 버튼 클릭시에 무슨 작업을 할 것인가!
            val listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        DialogInterface.BUTTON_POSITIVE ->
                            binding.tvTitle.text = "BUTTON_POSITIVE"
                        DialogInterface.BUTTON_NEUTRAL ->
                            binding.tvTitle.text = "BUTTON_NEUTRAL"
                        DialogInterface.BUTTON_NEGATIVE ->
                            binding.tvTitle.text = "BUTTON_NEGATIVE"
                    }
                }
            }

            builder.setPositiveButton("Positive", listener)
            builder.setNegativeButton("Negative", listener)
            builder.setNeutralButton("Neutral", listener)

            builder.show()
        }

        // 2. 커스텀 다이얼로그
        binding.btn2Custom.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            val v1 = layoutInflater.inflate(R.layout.dialog, null)
            builder.setView(v1)

            // p0에 해당 AlertDialog가 들어온다. findViewById를 통해 view를 가져와서 사용
            val listener = DialogInterface.OnClickListener { p0, p1 ->
                val alert = p0 as AlertDialog
                val edit1: EditText? = alert.findViewById<EditText>(R.id.editText)
                val edit2: EditText? = alert.findViewById<EditText>(R.id.editText2)

                binding.tvTitle.text = "이름 : ${edit1?.text}"
                binding.tvTitle.append(" / 나이 : ${edit2?.text}")
            }

            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소", null)

            builder.show()
        }

        // 3. 날짜 다이얼로그
        binding.btn3Date.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val listener = DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                // i년 i2월 i3일
                binding.tvTitle.text = "${i}년 ${i2 + 1}월 ${i3}일"
            }

            var picker = DatePickerDialog(this, listener, year, month, day)
            picker.show()
        }

        // 4. 시간 다이얼로그
        binding.btn4Time.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR)
            val minute = calendar.get(Calendar.MINUTE)

            val listener = TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                binding.tvTitle.text = "${i}시 ${i2}분"
            }

            val picker = TimePickerDialog(this, listener, hour, minute, false) // true하면 24시간 제
            picker.show()
        }

//        // 5. 프로그레스 다이얼로그
//        binding.btn5Porgress.setOnClickListener {
//            // 권장하진 않지만 사용은 가능하다.
//            pro = ProgressDialog.show(this, "타이틀입니다.", "메시지입니다.")
//
//            // 핸들러를 통해서 종료 작업을 한다.
//            val handler = Handler()
//            val thread = Runnable { pro?.cancel() }
//            handler.postDelayed(thread, 5000) // 딜레이는 5초
//        }


//6. 프로그래스 다이얼로그 다른 방식. (커스텀과 비슷)
        binding.btn5Porgress.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("프로그래스바")
            builder.setIcon(R.mipmap.ic_launcher)

            val v1 = layoutInflater.inflate(R.layout.progressbar, null)
            builder.setView(v1)

            builder.show()
        }


    }
}