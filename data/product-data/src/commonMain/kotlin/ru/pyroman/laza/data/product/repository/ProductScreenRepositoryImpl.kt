package ru.pyroman.laza.data.product.repository

import ru.pyroman.laza.domain.product.repository.ProductScreenRepository
import ru.pyroman.laza.data.product.datasource.network.ProductNetworkDataSourceKtor

class ProductScreenRepositoryImpl(
    private val networkDataSource: ProductNetworkDataSourceKtor,
) : ProductScreenRepository {

    override suspend fun getProductScreenData(): String {
        return networkDataSource.getProductScreen()
    }
}