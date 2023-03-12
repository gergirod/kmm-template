package com.example.kmm_template.data.util

import kotlinx.coroutines.flow.Flow

actual open class CommonFlow<T> actual constructor(
    private val flow: Flow<T>
) : Flow<T> by flow