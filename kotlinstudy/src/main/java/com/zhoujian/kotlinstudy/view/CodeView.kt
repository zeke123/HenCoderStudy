package com.zhoujian.kotlinstudy.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import kotlin.random.Random

class CodeView(context: Context?, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {
    private val paint: Paint = Paint().apply {
        this.isAntiAlias = true
        this.style = Paint.Style.STROKE
        this.color = Color.parseColor("#03DAC5")
    }

    private val codeList = arrayOf(
        "kotlin",
        "android",
        "java",
        "http",
        "https",
        "okHttp",
        "retrofit",
        "tcp/ip"
    )

    init {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        gravity = Gravity.CENTER
        setBackgroundColor(Color.parseColor("#000000"))
        setTextColor(Color.WHITE)
        updateCode()
    }

    public fun updateCode() {
        val random = Random.nextInt(codeList.size)
        val code = codeList[random]
        text = code
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(0f, height.toFloat(), width.toFloat(), 0.toFloat(), paint)
    }
}