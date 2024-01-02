package ru.pyroman.laza.base.divkit.ui

import org.kodein.di.instance
import ru.pyroman.laza.base.divkit.ui.presenter.DivkitPresenterFactory
import ru.pyroman.laza.base.divkit.ui.usecases.DivkitUseCases
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.provider
import ru.pyroman.laza.common.core.di.singleton

internal val divkitCommonModule = module("divkitCommonModule") {

    provider {
        DivkitUseCases(
            getScreenDataUseCase = instance()
        )
    }

    singleton {
        DivkitPresenterFactory()
    }
}