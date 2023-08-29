package ru.pyroman.laza.domain.product

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import ru.pyroman.laza.domain.product.usecase.GetProductScreenUseCase

val productDomainModule = DI.Module("productDomainModule") {
    bind<GetProductScreenUseCase>() with provider {
        GetProductScreenUseCase(
            productScreenRepository = instance(),
        )
    }
}