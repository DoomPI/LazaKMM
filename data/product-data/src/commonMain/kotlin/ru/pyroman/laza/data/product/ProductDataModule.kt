package ru.pyroman.laza.data.product

import ru.pyroman.laza.data.product.datasource.network.ProductNetworkDataSourceKtor
import org.kodein.di.*
import ru.pyroman.laza.domain.product.repository.ProductScreenRepository
import ru.pyroman.laza.data.product.repository.ProductScreenRepositoryImpl

val productDataModule = DI.Module("productDataModule") {

    bind<ProductNetworkDataSourceKtor>() with provider {
        ProductNetworkDataSourceKtor(
            httpClient = instance(),
        )
    }

    bind<ProductScreenRepository>() with singleton {
        ProductScreenRepositoryImpl(
            networkDataSource = instance(),
        )
    }
}