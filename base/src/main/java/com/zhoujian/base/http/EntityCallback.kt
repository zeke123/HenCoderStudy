package com.zhoujian.base.http

interface EntityCallback<T> {
    fun onSuccess(entity: T)

    fun onFailure(message: String?)
}