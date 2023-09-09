package ru.pyroman.laza.data.product

import org.kodein.di.instance
import ru.pyroman.laza.base.divkit.data.divkitDataModule
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.provider
import ru.pyroman.laza.domain.product.repository.ProductScreenRepository
import ru.pyroman.laza.data.product.repository.ProductScreenRepositoryImpl

val productDataModule = module("productDataModule") {

    importAll(
        divkitDataModule
    )

    provider<ProductScreenRepository> {
        ProductScreenRepositoryImpl(
            divkitRepository = instance(),
        )
    }
}