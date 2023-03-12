package com.example.kmm_template.data.util

enum class TranslateError {
    SERVICE_UNAVAILABLE,
    CLIENT_ERROR,
    SERVER_ERROR,
    UNKNOWN_ERROR
}

class TranslateException(error: TranslateError) :
    Exception("this is an error $error")