package ru.pyroman.laza.base.divkit.domain

import org.kodein.di.instance
import ru.pyroman.laza.base.divkit.domain.usecase.GetScreenDataUseCase
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.provider

val divkitDomainModule = module("divkitDomainModule") {

    provider {
        GetScreenDataUseCase(
            divkitRepository = instance(),
        )
    }
}