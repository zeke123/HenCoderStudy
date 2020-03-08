package com.zhoujian.drawandxfermode.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.zhoujian.drawandxfermode.utils.PixelUtil
import kotlin.math.cos
import kotlin.math.sin

class PieChart(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    //圆弧外边界
    private val rectF: RectF = RectF()
    //定义半径
    private val radius: Float = PixelUtil.dp2px(150f)
    //定义偏移量
    private val offsetLength = PixelUtil.dp2px(20f)
    //便宜索引
    private val offsetIndex: Int = 2
    //定义角度
    private val angles = intArrayOf(60, 20, 60, 80, 60, 80)
    //定义颜色
    private val colors = intArrayOf(
        Color.parseColor("#2B98F0"),
        Color.parseColor("#159588"),
        Color.parseColor("#9B2FAE"),
        Color.parseColor("#74B72A"),
        Color.parseColor("#516E79"),
        Color.parseColor("#A4C4DF")
    )

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rectF.set(
            width / 2f - radius, height / 2f - radius,
            width / 2f + radius, height / 2f + radius
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var currentAngle = 0
        //遍历数组
        for (index in angles.indices) {
            if (index == offsetIndex) {
                //对canvas进行便移
                canvas?.save()
                var x =
                    offsetLength * cos(Math.toRadians((currentAngle + angles[index] / 2f).toDouble()))
                var y =
                    offsetLength * sin(Math.toRadians((currentAngle + angles[index] / 2f).toDouble()))
                canvas?.translate(x.toFloat(), y.toFloat())
            }
            paint.color = colors[index]
            //画圆弧
            canvas?.drawArc(rectF, currentAngle.toFloat(), angles[index].toFloat(), true, paint)
            currentAngle += angles[index]
            if (index == offsetIndex) {
                canvas?.restore()
            }
        }
    }
}