package ru.pyroman.laza.domain.product

import org.kodein.di.instance
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.provider
import ru.pyroman.laza.domain.product.usecase.GetProductScreenUseCase

val productDomainModule = module("productDomainModule") {

    provider {
        GetProductScreenUseCase(
            productScreenRepository = instance(),
        )
    }
}