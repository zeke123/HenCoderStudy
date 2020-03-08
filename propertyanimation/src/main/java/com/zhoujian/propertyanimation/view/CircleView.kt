package com.zhoujian.propertyanimation.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.zhoujian.propertyanimation.utils.PixelUtil

class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        this.color = Color.RED
    }
    //半径
    private var radius: Float = PixelUtil.dp2px(50f)
    fun getRadius(): Float {
        return radius
    }
    fun setRadius(radius: Float) {
        this.radius = radius
        //触发重绘
        invalidate()
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //其实的半径为50，最终值为150f
        canvas?.drawCircle(width / 2f, height / 2f, radius, paint)
    }
}