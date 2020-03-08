package com.zhoujian.drawandxfermode.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.zhoujian.drawandxfermode.utils.PixelUtil
import kotlin.math.cos
import kotlin.math.sin

class InstrumentBoardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var pathDash = Path()
    //这个path，就是画圆弧时的path
    private var path = Path()
    private lateinit var effect: PathDashPathEffect
    //这个类可以计算出绘制的长度
    private lateinit var pathMeasure: PathMeasure

    companion object {
        //定义圆弧的半径
        private val RADIUS: Float = PixelUtil.dp2px(150f)
        private val STROKE_WIDTH: Float = PixelUtil.dp2px(2f)
        //圆弧打开的角度为90度
        private const val OPEN_ANGLE = 90f
        //指针的长度
        private val POINTER_LENGTH: Float = PixelUtil.dp2px(120f)
    }


    init {
        //设置为画线模式
        paint.style = Paint.Style.STROKE
        //设置画线宽度
        paint.strokeWidth = STROKE_WIDTH
        //圆弧上的刻度，相当于一个小矩形
        //小矩形的宽度：PixelUtil.dp2px(1f)
        //小矩形的高度：PixelUtil.dp2px(10f)
        pathDash.addRect(
            0f,
            0f,
            PixelUtil.dp2px(2f),
            PixelUtil.dp2px(10f),
            Path.Direction.CCW
        )
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.reset()
        path.addArc(
            width / 2 - RADIUS,
            height / 2 - RADIUS,
            width / 2 + RADIUS,
            height / 2 + RADIUS,
            90 + OPEN_ANGLE / 2,
            360 - OPEN_ANGLE
        )
        pathMeasure = PathMeasure(path, false)
        //给绘制设置效果:用图形来绘制效果
        //Path shape, float advance, float phase,Style style
        //advance:间隔多少画一个小矩形
        //phase:提前量是多少
        effect = PathDashPathEffect(
            pathDash,
            (pathMeasure!!.length - PixelUtil.dp2px(2f)) / 20,
            0f,
            PathDashPathEffect.Style.ROTATE
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //画圆弧，首先要确定圆弧的位置
        //left、top、right、bottom：距离左上右下的距离
        //startAngle :开始的角度
        //sweepAngle:圆弧扫过的角度
        //useCenter:是否经过中心
        //paint:画笔
        val left = width / 2 - RADIUS //左边距中心的距离减去半径
        val top = height / 2 - RADIUS //上边距离中心的距离减去半径
        val right = width / 2 + RADIUS //右边距离中心的距离加上半径
        val bottom = height / 2 + RADIUS //底部距离中心的距离加上半径
        val startAngle = 90 + OPEN_ANGLE / 2 //简单画草图，就可以计算出来
        val sweepAngle = 360 - OPEN_ANGLE //简单画草图，就可以计算出来
        canvas.drawArc(left, top, right, bottom, startAngle, sweepAngle, false, paint)
        //画刻度
        //给绘制设置效果:用图形来绘制效果
        //Path shape, float advance, float phase,Style style
        //advance:间隔多少画一个小矩形
        //phase:提前量是多少
        //在画弧之前加上绘制效果
        paint.pathEffect = effect
        canvas.drawArc(left, top, right, bottom, startAngle, sweepAngle, false, paint)
        //画完效果后，把效果去掉
        paint.pathEffect = null
        //画指针
        canvas.drawLine(
            width / 2.toFloat(),
            height / 2.toFloat(),
            width / 2 + POINTER_LENGTH * cos(getAngleFromMark(5)).toFloat(),
            height / 2 + POINTER_LENGTH * sin(getAngleFromMark(5)).toFloat(), paint
        )
    }

    private fun getAngleFromMark(mark: Int): Double {
        return Math.toRadians(90 + OPEN_ANGLE / 2 + ((360 - OPEN_ANGLE) / 20f * mark).toDouble())
    }
}
