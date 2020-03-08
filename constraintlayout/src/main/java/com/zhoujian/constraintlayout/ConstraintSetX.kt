package com.zhoujian.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class ConstraintSetX : AppCompatActivity() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_constraint_set)
//    }
//
//
//    fun onClick(view: View) {
//        val constraintLayout = view as ConstraintLayout
//        val constraintSet = ConstraintSet().apply {
//            clone(constraintLayout)
//            connect(
//                R.id.twitter,
//                ConstraintSet.BOTTOM,
//                ConstraintSet.PARENT_ID,
//                ConstraintSet.BOTTOM
//            )
//        }
//        constraintSet.applyTo(constraintLayout)
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_start)
    }


    fun onClick(view: View) {
        val constraintLayout = view as ConstraintLayout
        TransitionManager.beginDelayedTransition(constraintLayout)

        val constraintSet = ConstraintSet().apply {
            isForceId = false
            clone(
                this@ConstraintSetX,
                R.layout.activity_constraint_end
            )
        }
        constraintSet.applyTo(constraintLayout)
    }
}
