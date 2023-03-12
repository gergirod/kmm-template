package com.example.kmm_template.data.util

import android.content.Context
import com.example.kmm_template.database.AppDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(AppDatabase.Schema, context)
    }
}