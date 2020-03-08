package com.zhoujian.motionlayoutdemo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.zhoujian.motionlayoutdemo.R

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //MotionLayout 是ConstraintLayout 的子类
        //MotionLayout 可以用来做过渡动画
        //View动画  API 1
        //属性动画   API 11
        //过渡动画   API 18
        initViews()
        clickEvent()

        

    }

    private fun initViews() {
        button1 = findViewById<Button>(R.id.button1)
        button2 = findViewById<Button>(R.id.button2)
        button3 = findViewById<Button>(R.id.button3)
        button4 = findViewById<Button>(R.id.button4)
        button5 = findViewById<Button>(R.id.button5)
        button6 = findViewById<Button>(R.id.button6)
        button7 = findViewById<Button>(R.id.button7)
        button8 = findViewById<Button>(R.id.button8)
        button9 = findViewById<Button>(R.id.button9)
    }

    private fun clickEvent() {
        button1.setOnClickListener {
            startActivity(Intent(this, ObjectAnimatorActivity::class.java))
        }
        button2.setOnClickListener {
            startActivity(Intent(this, ObjectAnimator2Activity::class.java))
        }
        button3.setOnClickListener {
            startActivity(Intent(this, Go::class.java))
        }
        button4.setOnClickListener {
            startActivity(Intent(this, ConstraintSet::class.java))
        }
        button5.setOnClickListener {
            startActivity(Intent(this, MyMotionLayoutActivity::class.java))
        }
        button6.setOnClickListener {
            startActivity(Intent(this, SampleActivity::class.java))
        }

        button7.setOnClickListener {
            startActivity(Intent(this, HenCoderActivity::class.java))
        }

        button8.setOnClickListener {
            startActivity(Intent(this, YoutubeActivity::class.java))
        }
        button9.setOnClickListener {
            startActivity(Intent(this, MotionLayoutActivity::class.java))
        }
    }
}
