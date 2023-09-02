package ru.pyroman.laza.data.product.repository

import ru.pyroman.laza.data.product.datasource.network.ProductNetworkDataSource
import ru.pyroman.laza.domain.product.repository.ProductScreenRepository

internal class ProductScreenRepositoryImpl(
    private val networkDataSource: ProductNetworkDataSource,
) : ProductScreenRepository {

    override suspend fun getProductScreenData(): String {
        return networkDataSource.getProductScreen()
    }
}