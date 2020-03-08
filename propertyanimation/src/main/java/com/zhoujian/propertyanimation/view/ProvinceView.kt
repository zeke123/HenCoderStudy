package com.zhoujian.propertyanimation.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.zhoujian.propertyanimation.utils.PixelUtil

class ProvinceView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var province = "北京市"

    init {
        paint.textSize = PixelUtil.dp2px(30f)
        paint.textAlign = Paint.Align.CENTER
        //setLayerType(LAYER_TYPE_HARDWARE, null)
        //setLayerType(LAYER_TYPE_SOFTWARE, null)
        //setLayerType(LAYER_TYPE_NONE, null)
    }

    fun getProvince(): String = province
    fun setProvince(province: String?) {
        this.province = province!!
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(province, width / 2f, height / 2f, paint)
    }
}