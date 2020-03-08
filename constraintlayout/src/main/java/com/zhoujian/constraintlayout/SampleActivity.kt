package com.zhoujian.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout_sample)
//        setContentView(R.layout.activity_sample_weight)
//        setContentView(R.layout.activity_sample_baseline)
//        setContentView(R.layout.activity_sample_constrained)
//        setContentView(R.layout.activity_sample_bias)
//        setContentView(R.layout.activity_sample_gonemargin)
//        setContentView(R.layout.activity_sample_chainstyle)

        //约束布局：布局扁平化，减少布局嵌套，布局优化，反编译抖音，用很多约束布局
        //原来的线性布局还是推荐使用的
        //约束布局：至少有2个方向上的约束，一个水平方向，一个竖直方向
    }
}
