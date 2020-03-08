package com.zhoujian.constraintlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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
    private lateinit var button10: Button
    private lateinit var button11: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        clickEvent()

    }

    private fun clickEvent() {
        button1.setOnClickListener {
            startActivity(Intent(this, SampleActivity::class.java))
        }

        button2.setOnClickListener {
            startActivity(Intent(this, CircularPositioning::class.java))
        }

        button3.setOnClickListener {
            startActivity(Intent(this, DimensionRatio::class.java))
        }

        button4.setOnClickListener {
            startActivity(Intent(this, Percent::class.java))
        }
        button5.setOnClickListener {
            startActivity(Intent(this, GuideLineActivity::class.java))
        }
        button6.setOnClickListener {
            startActivity(Intent(this, Helpers::class.java))
        }
        button7.setOnClickListener {
            startActivity(Intent(this, CircularReveal::class.java))
        }

        button8.setOnClickListener {
            startActivity(Intent(this, PlaceHolder::class.java))
        }
        button9.setOnClickListener {
            startActivity(Intent(this, ConstraintSetX::class.java))
        }
        button10.setOnClickListener {
            startActivity(Intent(this, LinearActivity::class.java))
        }
        button11.setOnClickListener {
            startActivity(Intent(this, FlowActivity::class.java))
        }
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
        button10 = findViewById<Button>(R.id.button10)
        button11 = findViewById<Button>(R.id.button11)
    }
}
