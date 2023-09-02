package ru.pyroman.laza.common.core

import ru.pyroman.laza.common.core.json.serializationModule
import ru.pyroman.laza.common.core.ktor.ktorModule
import ru.pyroman.laza.common.core.di.module

val coreModule = module("coreModule") {
    importAll(
        serializationModule,
        ktorModule,
    )
}