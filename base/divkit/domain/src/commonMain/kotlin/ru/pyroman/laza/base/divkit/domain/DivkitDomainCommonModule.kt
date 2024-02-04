package ru.pyroman.laza.base.divkit.domain

import org.kodein.di.instance
import ru.pyroman.laza.base.divkit.domain.usecase.GetScreenDataUseCase
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.provider

val divkitDomainCommonModule = module("divkitDomainCommonModule") {

    provider {
        GetScreenDataUseCase(
            divkitRepository = instance(),
        )
    }
}