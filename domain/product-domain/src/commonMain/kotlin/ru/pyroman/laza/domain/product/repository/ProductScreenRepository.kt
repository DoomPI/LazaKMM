package ru.pyroman.laza.domain.product.repository

interface ProductScreenRepository {

    suspend fun getProductScreenData(): String
}