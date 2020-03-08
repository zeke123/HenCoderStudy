package com.zhoujian.propertyanimation.utils

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.TypedValue
import com.zhoujian.propertyanimation.R

object PixelUtil {
    fun dp2px(dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp,
            Resources.getSystem().displayMetrics
        )
    }

    fun getAvatar(res: Resources, width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(res, R.mipmap.ic_launcher, options)
        options.apply {
            this.inJustDecodeBounds = false
            this.inDensity = options.outWidth
            this.inTargetDensity = width
        }
        return BitmapFactory.decodeResource(res, R.mipmap.ic_launcher, options)
    }
    fun getZForCamera(): Float {
        return -4 * Resources.getSystem().displayMetrics.density
    }
}