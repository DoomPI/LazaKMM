package ru.pyroman.laza.common.core

import ru.pyroman.laza.common.core.json.serializationModule
import ru.pyroman.laza.common.core.ktor.ktorModule
import org.kodein.di.DI

val coreModule = DI.Module("coreModule") {
    importAll(
        serializationModule,
        ktorModule,
    )
}