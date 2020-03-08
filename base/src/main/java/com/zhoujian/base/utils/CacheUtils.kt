package com.zhoujian.base.utils

import android.content.Context
import com.zhoujian.base.R
import com.zhoujian.base.common.BaseApplication

object CacheUtils {

    private val context: Context = BaseApplication.currentApplication
    private val SP =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun save(key: String, value: String) {
        SP.edit().putString(key, value).apply()
    }

    fun get(key: String): String? {
        return SP.getString(key, null)
    }
}