package com.example.apple_market1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apple_market1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolBar.title = "내배캠동"


        //싱글톤과 데이터 연결
        val productList = ProductSingleton.getproductList()
        // ProductAdapter 인스턴스 생성 및 데이터 전달
        val adapter = ProductAdapter(productList as ArrayList<ProductData>)
        binding.rvProductList.adapter = adapter
        binding.rvProductList.layoutManager = LinearLayoutManager(this)



        adapter.itemClick = object : ProductAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val product = adapter.getItem(position)
                // 클릭한 아이템 가져오기
                val intent = Intent(this@MainActivity, ProductDetailActivity::class.java)
                intent.putExtra("seller", product.seller)
                intent.putExtra("address", product.address)
                intent.putExtra("productName", product.productName)
                intent.putExtra("productImg", product.productImg)
                intent.putExtra("introduction", product.introduction)
                intent.putExtra("price", product.price)

                startActivity(intent)

            }
        }
    }

    // 뒤로가기 버튼 동작을 가로채서 팝업 표시
    override fun onBackPressed() {
        showExitDialog()
    }

    //뒤로가기 버튼 클릭 시 종료 다이얼로그 표시
    private fun showExitDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("앱 종료")
        builder.setIcon(R.drawable.bubble_chat)


        builder.setMessage("앱을 종료하시겠습니까?")
            .setPositiveButton("확인") { _: DialogInterface, _: Int ->
                finish() // 앱 종료
            }
            .setNegativeButton("취소") { dialog: DialogInterface, _: Int ->
                dialog.dismiss() // 다이얼로그 닫기
            }
            .show()
    }
}
