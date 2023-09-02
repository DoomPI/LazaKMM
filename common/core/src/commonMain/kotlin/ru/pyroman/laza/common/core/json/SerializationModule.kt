package ru.pyroman.laza.common.core.json

import kotlinx.serialization.json.Json
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.singleton

internal val serializationModule = module("serialization") {
    singleton {
        Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
    }
}