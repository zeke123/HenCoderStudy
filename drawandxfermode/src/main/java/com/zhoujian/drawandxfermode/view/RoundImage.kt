package com.zhoujian.drawandxfermode.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.zhoujian.drawandxfermode.R
import com.zhoujian.drawandxfermode.utils.PixelUtil

class RoundImage(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap
    private var rectF = RectF()
    private var xfermode: Xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

    companion object {
        private val width: Float = PixelUtil.dp2px(300f)
    }

    init {
        bitmap = getAvatar(Companion.width.toInt())
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val offset = (width - Companion.width) / 2
        rectF[offset, offset, offset + Companion.width] = offset + Companion.width
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val offset = (width - Companion.width) / 2
        //外面画一个大一点的圆
        paint.color = Color.RED
        canvas.drawCircle(
            Companion.width / 2 + offset,
            Companion.width / 2 + offset,
            Companion.width / 2 + PixelUtil.dp2px(3f), paint
        )
        val saveLayerId = canvas.saveLayer(rectF, paint)
        canvas.drawCircle(
            Companion.width / 2 + offset,
            Companion.width / 2 + offset,
            Companion.width / 2, paint
        )
        paint.xfermode = xfermode

        canvas.drawBitmap(bitmap!!, offset, offset, paint)
        paint.xfermode = null
        canvas.restoreToCount(saveLayerId)
    }

    private fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.mipmap.girl, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.mipmap.girl, options)
    }
}
