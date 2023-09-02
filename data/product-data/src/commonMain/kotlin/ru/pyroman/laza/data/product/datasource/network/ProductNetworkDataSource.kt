package ru.pyroman.laza.data.product.datasource.network

internal interface ProductNetworkDataSource {

    suspend fun getProductScreen(): String
}