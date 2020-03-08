package com.zhoujian.propertyanimation.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.zhoujian.propertyanimation.utils.PixelUtil

class CameraView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val imageWidth: Float = PixelUtil.dp2px(200f)
    private val imageOffset: Float = PixelUtil.dp2px(80f)
    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap
    private var camera: Camera = Camera()

    private var bottomFlip = 0f
    private var topFlip = 0f
    private var flipRotation = 0f

    init {
        bitmap = PixelUtil.getAvatar(resources, imageWidth.toInt())
        camera.setLocation(0f, 0f, PixelUtil.getZForCamera()) // -8 * 72
    }

    fun getTopFlip(): Float = topFlip
    fun setTopFlip(topFlip: Float) {
        this.topFlip = topFlip
        //触发重绘
        invalidate()
    }

    fun getBottomFlip(): Float = bottomFlip
    fun setBottomFlip(bottomFlip: Float) {
        this.bottomFlip = bottomFlip
        //触发重绘
        invalidate()
    }

    fun getFlipRotation(): Float = flipRotation
    fun setFlipRotation(flipRotation: Float) {
        this.flipRotation = flipRotation
        //触发重绘
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.apply {
            this.save();
            this.translate(imageOffset + imageWidth / 2f, imageOffset + imageWidth / 2f)
            this.rotate(-flipRotation)
        }
        camera.apply {
            this.save()
            this.rotateX(topFlip)
            this.applyToCanvas(canvas)
            this.restore()
        }
        canvas?.apply {
            this.clipRect(-imageWidth, -imageWidth, imageWidth, 0f);
            this.rotate(flipRotation);
            this.translate(-(imageOffset + imageWidth / 2f), -(imageOffset + imageWidth / 2f));
            this.drawBitmap(bitmap, imageOffset, imageOffset, paint)
            this.restore();
        }


        canvas?.save()
        canvas?.translate(imageOffset + imageWidth / 2f, imageOffset + imageWidth / 2f)
        canvas?.rotate(-flipRotation)
        camera.save()
        camera.rotateX(bottomFlip)
        camera.applyToCanvas(canvas)
        camera.restore();
        canvas?.clipRect(-imageWidth, 0f, imageWidth, imageWidth)
        canvas?.rotate(flipRotation);
        canvas?.translate(-(imageOffset + imageWidth / 2f), -(imageOffset + imageWidth / 2f))
        canvas?.drawBitmap(bitmap, imageOffset, imageOffset, paint)
        canvas?.restore()

    }
}


