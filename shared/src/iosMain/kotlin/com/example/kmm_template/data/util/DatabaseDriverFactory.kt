package com.example.kmm_template.data.util

import co.touchlab.sqliter.DatabaseConfiguration
import com.example.kmm_template.database.AppDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.squareup.sqldelight.drivers.native.wrapConnection

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(
            DatabaseConfiguration(
                name = null,
                version = 1,
                create = { wrapConnection(it, AppDatabase.Schema::create) },
                inMemory = true
            )
        )
    }
}