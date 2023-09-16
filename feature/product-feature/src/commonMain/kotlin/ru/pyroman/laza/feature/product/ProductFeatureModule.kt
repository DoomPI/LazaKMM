package ru.pyroman.laza.feature.product

import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.provider
import ru.pyroman.laza.feature.product.presenter.ProductPresenter

val productFeatureModule = module("productFeatureModule") {

    provider {
        ProductPresenter()
    }
}