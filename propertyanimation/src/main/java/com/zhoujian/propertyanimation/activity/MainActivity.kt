package com.zhoujian.propertyanimation.activity

import android.animation.*
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewPropertyAnimator
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import com.zhoujian.propertyanimation.R
import com.zhoujian.propertyanimation.evaluator.PointFEvaluator
import com.zhoujian.propertyanimation.evaluator.ProvinceEvaluator
import com.zhoujian.propertyanimation.utils.PixelUtil
import com.zhoujian.propertyanimation.view.CameraView
import com.zhoujian.propertyanimation.view.CircleView
import com.zhoujian.propertyanimation.view.PointView
import com.zhoujian.propertyanimation.view.ProvinceView

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var circleView: CircleView
    private lateinit var cameraView: CameraView
    private lateinit var pointView: PointView
    private lateinit var provinceView: ProvinceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //option+command+M 抽取方法
        //option+command+V 提取局部变量
        //option+command+F 提取成员变量
        //option+command+C 提取为常量
        //option+command+L 代码格式化

        //imageView = findViewById<ImageView>(R.id.view)
        //circleView = findViewById<CircleView>(R.id.view)
        //cameraView = findViewById<CameraView>(R.id.view)
        //pointView = findViewById<PointView>(R.id.view)
        provinceView = findViewById<ProvinceView>(R.id.view)

        //propertyAnimator()
        //objectAnimator()
        //customPropertyAnimation()
        //cameraViewAnimation()
        //propertyValuesMethod()
        //keyFrameMethod()
        //pointViewAnimation()
        provincesAnimation()

    }

    private fun provincesAnimation() {

        val animator =
            ObjectAnimator.ofObject(provinceView, "province", ProvinceEvaluator(), "澳门特别行政区")
        animator.apply {
            this.duration = 10000
            this.startDelay = 2000
            this.interpolator = AccelerateDecelerateInterpolator()
            this.start()
        }


    }

    /**
     * TypeEvaluator 用于自定义动画使用
     * ofInt、ofFloat 已有自带的IntEvaluator、FloatEvaluator
     * 如果需要实现自定义动画，需要实现TypeEvaluator这个接口，定义自己的动画
     *
     */
    private fun pointViewAnimation() {
        val pointF: PointF = PointF(PixelUtil.dp2px(180f), PixelUtil.dp2px(240f))
        val animator = ObjectAnimator.ofObject(pointView, "point", PointFEvaluator(), pointF)
        animator.apply {
            this.duration = 1000
            this.startDelay = 1000
            this.start()
        }
    }


    /**
     * Keyframe、PropertyValuesHolder 配合在一起可以设置关键帧的动画
     */
    private fun keyFrameMethod() {
        val length = PixelUtil.dp2px(200f)
        val keyframeOne = Keyframe.ofFloat(0f, 0f)
        val keyframeTwo = Keyframe.ofFloat(0.1f, 2f * length)
        val keyframeThree = Keyframe.ofFloat(0.9f, 0.6f * length)
        val keyframeFour = Keyframe.ofFloat(1f, 1f * length)
        val valuesHolder = PropertyValuesHolder.ofKeyframe(
            "translationX",
            keyframeOne,
            keyframeTwo,
            keyframeThree,
            keyframeFour
        )
        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, valuesHolder)
        objectAnimator.apply {
            this.startDelay = 2000
            this.duration = 2000
            this.interpolator = AccelerateDecelerateInterpolator()
            this.start()
        }

    }

    /**
     * PropertyValuesHolder 可以用于更加详细的动画
     */
    private fun propertyValuesMethod() {
        val bottomFlipAnimator = PropertyValuesHolder.ofFloat("bottomFlip", 45f)
        val topFlipAnimator = PropertyValuesHolder.ofFloat("topFlip", -45f)
        val flipRotationAnimator = PropertyValuesHolder.ofFloat("flipRotation", 270f)
        ObjectAnimator.ofPropertyValuesHolder(
            cameraView,
            bottomFlipAnimator,
            topFlipAnimator,
            flipRotationAnimator
        ).apply {
            this.duration = 1000
            this.startDelay = 1000
            this.start()
        }
    }

    /**
     * AnimatorSet 可以将多个动画合并在一起
     * 可以设置先后顺序或者并列顺序执行
     */
    private fun cameraViewAnimation() {
        val bottomFlipAnimator = ObjectAnimator.ofFloat(cameraView, "bottomFlip", 45f)
        bottomFlipAnimator.apply {
            this.duration = 1000
            this.startDelay = 1000
        }
        val topFlipAnimator = ObjectAnimator.ofFloat(cameraView, "topFlip", -45f)
        topFlipAnimator.apply {
            this.duration = 1000
            this.startDelay = 1000
        }
        val flipRotationAnimator = ObjectAnimator.ofFloat(cameraView, "flipRotation", 270f)
        flipRotationAnimator.apply {
            this.duration = 1000
            this.startDelay = 1000
        }
        AnimatorSet().apply {
            this.playSequentially(bottomFlipAnimator, flipRotationAnimator, topFlipAnimator)
            this.duration = 1000
            this.start()
        }
    }

    /**
     * 自定义属性动画，需要设置getter和setter方法
     * 并且 setter ⽅方法里需要调用 invalidate() 来触发重绘
     */
    private fun customPropertyAnimation() {
        //自定义属性动画
        //radius:属性名，自定义View中要重写get、set方法,动态改变radius的值
        ObjectAnimator.ofFloat(circleView, "radius", PixelUtil.dp2px(150f)).apply {
            this.startDelay = 2000
            this.duration = 1000
            this.start()
        }
    }

    /**
     * ObjectAnimator:属性动画
     * 可以自定义属性设置动画
     */
    private fun objectAnimator() {
        //属性动画
        ObjectAnimator.ofFloat(imageView, "translationX", PixelUtil.dp2px(100f)).apply {
            this.startDelay = 2000
            this.duration = 1000
            this.start()
        }
    }

    /**
     * 属性动画:ViewPropertyAnimator
     *
     */
    private fun propertyAnimator() {
        var viewPropertyAnimator: ViewPropertyAnimator = imageView.animate()
        viewPropertyAnimator.apply {
            this.translationX(300f)
            this.duration = 1000
            this.startDelay = 1000
            this.start()
        }
    }
}
