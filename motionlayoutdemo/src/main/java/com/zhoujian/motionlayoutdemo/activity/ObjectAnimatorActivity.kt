package com.zhoujian.motionlayoutdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.zhoujian.motionlayoutdemo.R
import com.zhoujian.motionlayoutdemo.utils.dp

class ObjectAnimatorActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var root: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator)
        root = findViewById(R.id.root)
        findViewById<ImageView>(R.id.heart).setOnClickListener(this)
    }

    override fun onClick(v: View) {

        //过渡动画效果
        TransitionManager.beginDelayedTransition(v.parent as ViewGroup)
        //1、过渡动画是指2个场景之间的过渡  开始场景  结束场景
        //2、创建动画、播放动画

        val layoutParams = v.layoutParams as FrameLayout.LayoutParams
        layoutParams.gravity = Gravity.END
        v.layoutParams = layoutParams


//        v.animate().translationX(200f.dp).start()
    }
}
