package com.example.kmm_template.data.util

import io.ktor.client.*

expect class HttpClientFactory {
    fun create() : HttpClient
}

fun a() {

}