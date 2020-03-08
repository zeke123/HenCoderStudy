package com.zhoujian.textandtransformation.avtivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.zhoujian.textandtransformation.R

class MainActivity : AppCompatActivity() {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //option+enter
        initView()
        clickEvent()
    }


    private fun initView() {
        button1 = findViewById<Button>(R.id.button1)
        button2 = findViewById<Button>(R.id.button2)
        button3 = findViewById<Button>(R.id.button3)
    }


    private fun clickEvent() {
        button1.setOnClickListener {

            startActivity(Intent(this, SportViewActivity::class.java))
        }
        button2.setOnClickListener {

        }
        button3.setOnClickListener {

        }
    }
}
