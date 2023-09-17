package ru.pyroman.laza.feature.auth

import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.provider
import ru.pyroman.laza.feature.auth.presenter.AuthPresenter

val authFeatureModule = module("authFeatureModule") {

    provider {
        AuthPresenter()
    }
}