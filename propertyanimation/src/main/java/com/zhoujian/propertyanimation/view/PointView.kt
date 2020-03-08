package com.zhoujian.propertyanimation.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import com.zhoujian.propertyanimation.utils.PixelUtil

class PointView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var point: PointF = PointF()

    init {
        paint.strokeWidth = PixelUtil.dp2px(20f)
        paint.strokeCap = Paint.Cap.ROUND
    }

    fun getPoint(): PointF = point
    fun setPoint(point: PointF) {
        this.point = point
        invalidate()

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPoint(point.x, point.y, paint)
    }

}