package ru.pyroman.laza.data.product.datasource.network

import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.http.*

class ProductNetworkDataSourceKtor(
    private val httpClient: HttpClient,
) {

    suspend fun getProductScreen(): String {
        return httpClient.get {
            url {
                protocol = URLProtocol.HTTP
                host = "10.0.2.2:8080"
                path("product")
            }
        }.body()
    }
}