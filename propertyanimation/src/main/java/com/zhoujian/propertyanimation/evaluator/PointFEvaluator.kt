package com.zhoujian.propertyanimation.evaluator

import android.animation.TypeEvaluator
import android.graphics.PointF

class PointFEvaluator() : TypeEvaluator<PointF> {
    override fun evaluate(fraction: Float, startValue: PointF?, endValue: PointF?): PointF {
        val x = startValue!!.x + (endValue!!.x - startValue.x) * fraction
        val y = startValue.y + (endValue.y - startValue.y) * fraction
        return PointF(x, y)
    }
}