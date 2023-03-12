package com.example.kmm_template.data.base.util

sealed class ResultWrapper<T>(val data: T?, val throwable: Throwable? = null) {
    class Success<T>(data: T) : ResultWrapper<T>(data)
    class Error<T>(throwable: Throwable) : ResultWrapper<T>(null, throwable)
}
