package com.zhoujian.lesson.presenter

import com.zhoujian.lesson.activity.LessonActivity
import com.zhoujian.base.http.EntityCallback
import com.zhoujian.base.http.HttpClient
import com.zhoujian.base.utils.Utils
import com.zhoujian.lesson.bean.Lesson

class LessonPresenter(private val activity: LessonActivity) {

    private var lessons: List<Lesson> = ArrayList()

    companion object {
        const val LESSON_PATH = "lessons"
    }

    fun fetchData() {
        HttpClient.get<List<Lesson>>(LESSON_PATH, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(entity: List<Lesson>) {
                this@LessonPresenter.lessons = entity
                activity.runOnUiThread { activity.showResult(lessons) }
            }

            override fun onFailure(message: String?) {
                activity.runOnUiThread { Utils.toast(message) }
            }
        })
    }

    fun showPlayback() {
        activity.showResult(lessons.filter {
            it.state == Lesson.State.PLAYBACK
        })
    }
}