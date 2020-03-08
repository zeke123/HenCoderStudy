package com.zhoujian.motionlayoutdemo.activity

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zhoujian.motionlayoutdemo.R

class MyMotionLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mymotion_layout)
        findViewById<RatingBar>(R.id.rating_film_rating).rating = 4.5f
        findViewById<TextView>(R.id.text_film_title).text = getString(R.string.film_title)
        findViewById<TextView>(R.id.text_film_description).text =
            getString(R.string.film_description)

    }
}
