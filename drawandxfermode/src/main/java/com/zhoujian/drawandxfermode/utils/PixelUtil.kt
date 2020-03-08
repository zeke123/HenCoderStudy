package com.zhoujian.drawandxfermode.utils

import android.content.res.Resources
import android.util.TypedValue

object PixelUtil {

    fun dp2px(dp: Float): Float = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        Resources.getSystem().displayMetrics
    )


}