package com.zhoujian.textandtransformation.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color.parseColor
import android.graphics.Paint
import android.graphics.Paint.*
import android.graphics.Rect
import android.graphics.Typeface.createFromAsset
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable
import com.zhoujian.textandtransformation.utils.PixelUtil

class SportView(context: Context?, @Nullable attrs: AttributeSet?) :
    View(context, attrs) {

    companion object {
        private val RING_WIDTH: Float = PixelUtil.dp2px(20f)
        private val RADIUS: Float = PixelUtil.dp2px(150f)
        private val CIRCLE_COLOR = parseColor("#90A4AE")
        private val HIGHLIGHT_COLOR = parseColor("#FF4081")
    }

    private var paint = Paint(ANTI_ALIAS_FLAG)
    private var text = "abab"
    private val bounds = Rect()
    private var fontMetrics: FontMetrics = FontMetrics()

    init {
        paint.textSize = PixelUtil.dp2px(100f)
        paint.typeface = createFromAsset(
            getContext().assets,
            "Quicksand-Regular.ttf"
        )
        paint.textAlign = Align.CENTER
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 绘制环
        paint.apply {
            this.style = Style.STROKE
            this.color = CIRCLE_COLOR
            this.strokeWidth = RING_WIDTH
        }
        canvas.drawCircle(width / 2f, height / 2f, RADIUS, paint)


        // 绘制进度条
        paint.color = HIGHLIGHT_COLOR
        paint.strokeCap = Cap.ROUND
        canvas.drawArc(
            width / 2f - RADIUS,
            height / 2f - RADIUS,
            width / 2f + RADIUS,
            height / 2f + RADIUS,
            (-90).toFloat(),
            225f,
            false,
            paint
        )
        paint.strokeCap = Cap.BUTT
        // 绘制文字
        paint.style = Style.FILL
        //paint.getTextBounds(text, 0, text.length(), bounds);
        //int offset = (bounds.top + bounds.bottom) / 2;
        paint.getFontMetrics(fontMetrics)
        val offset = (fontMetrics.descent + fontMetrics.ascent) / 2
        canvas.drawText(text, width / 2f, height / 2f - offset, paint)


        //绘制文字靠left和top
        paint.textAlign = Align.LEFT
        paint.getTextBounds(text, 0, text.length, bounds)
        paint.textSize = PixelUtil.dp2px(150f)
        canvas.drawText(text, (-bounds.left).toFloat(), (-bounds.top).toFloat(), paint)
        paint.textSize = PixelUtil.dp2px(15f)
        paint.getTextBounds(text, 0, text.length, bounds)
        canvas.drawText(text, (-bounds.left).toFloat(), -bounds.top + paint.fontSpacing, paint)
    }
}
