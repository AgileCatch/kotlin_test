package com.example.apple_market1

import android.annotation.SuppressLint
import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.DialogInterface
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apple_market1.ProductSingleton.productList
import com.example.apple_market1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter

    private val getResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { reslut ->
            if (reslut.resultCode == Activity.RESULT_OK) {
                val data = reslut.data
                val position = data?.getIntExtra("position", -1)
                val likeCount = data?.getIntExtra("likeCount", -1)
                if (position != -1 && likeCount != -1) {
                    if (likeCount != null) {
                        productList[position!!].like = likeCount
                    }
                    adapter.notifyDataSetChanged()
                }
            }
        }
//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolBar.title = "내배캠동"
        // 툴바 메뉴 아이템 클릭 리스너 설정
        binding.toolBar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.notification -> {
                    notification()
                    true
                }

                else -> false
            }
        }


        //싱글톤과 데이터 연결
        val productList = ProductSingleton.getproductList()
        adapter = ProductAdapter(productList as ArrayList<ProductData>)
        binding.rvProductList.adapter = adapter

        val recyclerView = binding.rvProductList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        // 플로팅 버튼 및 스크롤 설정
        val fabUpArrow = binding.fabUpArrow
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    fabUpArrow.show() // 아래로 스크롤하면 플로팅 버튼 보이기

                } else {
                    fabUpArrow.hide() // 위로 스크롤하면 플로팅 버튼 숨기기
                }
            }
        })

        fabUpArrow.setOnClickListener {
            recyclerView.smoothScrollToPosition(0) // 최상단으로 스크롤
        }

        adapter.itemClick = object : ProductAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                // 상품 클릭 이벤트 처리
                val product = adapter.getItem(position)
                val intent = Intent(this@MainActivity, ProductDetailActivity::class.java)
                intent.putExtra("position", position)
                getResult.launch(intent)
            }
        }
        adapter.itemLongClick = object : ProductAdapter.ItemLongClick {
            override fun onLongClick(view: View, position: Int) {

                // 상품 롱클릭 이벤트 처리 (삭제 확인 다이얼로그 띄우기 등)
                showDeleteDialog(position)

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


        builder.setMessage("정말 앱을 종료하시겠습니까?")
            .setPositiveButton("확인") { _: DialogInterface, _: Int ->
                finish() // 앱 종료
            }
            .setNegativeButton("취소") { dialog: DialogInterface, _: Int ->
                dialog.dismiss() // 다이얼로그 닫기
            }
            .show()
    }

    @SuppressLint("애플마켓")
    fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 26 버전 이상
            val channelId = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                // 채널에 다양한 정보 설정
                description = "My Channel One Description"
                setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes)
                enableVibration(true)
            }
            // 채널을 NotificationManager에 등록
            manager.createNotificationChannel(channel)

            // 채널을 이용하여 builder 생성
            builder = NotificationCompat.Builder(this, channelId)

        } else {
            // 26 버전 이하
            builder = NotificationCompat.Builder(this)
        }

        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        // 알림의 기본 정보
        builder.run {
            setSmallIcon(R.mipmap.ic_launcher)
            setWhen(System.currentTimeMillis())
            setContentTitle("키워드 알림")
            setContentText("설정한 키워드에 대한 알림이 도착했습니다!!")
            addAction(
                R.mipmap.ic_launcher,
                "Action",
                pendingIntent
            )
        }
        manager.notify(11, builder.build())
    }

    private fun showDeleteDialog(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("삭제 확인")
        builder.setMessage("해당 상품을 삭제하시겠습니까?")
        builder.setPositiveButton("확인") { _, _ ->
            deleteProduct(position)
        }
        builder.setNegativeButton("취소", null)
        builder.show()
    }

    private fun deleteProduct(position: Int) {
        if (position in 0 until productList.size) {
            adapter.removeItem(position)
            binding.rvProductList.adapter?.notifyItemRemoved(position)
            Toast.makeText(this, "상품이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }


}

