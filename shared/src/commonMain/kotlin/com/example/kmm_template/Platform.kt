package com.example.kmm_template

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform