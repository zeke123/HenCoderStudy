package com.zhoujian.drawandxfermode.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.zhoujian.drawandxfermode.R

class PicChartActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            startActivity(Intent(this, BoardViewActivity::class.java))
        }
    }
}
