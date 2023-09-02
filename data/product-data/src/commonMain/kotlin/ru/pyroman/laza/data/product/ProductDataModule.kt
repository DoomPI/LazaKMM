package ru.pyroman.laza.data.product

import org.kodein.di.instance
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.provider
import ru.pyroman.laza.common.core.di.singleton
import ru.pyroman.laza.data.product.datasource.network.ProductNetworkDataSourceKtor
import ru.pyroman.laza.data.product.datasource.network.ProductNetworkDataSource
import ru.pyroman.laza.domain.product.repository.ProductScreenRepository
import ru.pyroman.laza.data.product.repository.ProductScreenRepositoryImpl

val productDataModule = module("productDataModule") {

    singleton<ProductNetworkDataSource> {
        ProductNetworkDataSourceKtor(
            httpClient = instance(),
        )
    }

    provider<ProductScreenRepository> {
        ProductScreenRepositoryImpl(
            networkDataSource = instance(),
        )
    }
}