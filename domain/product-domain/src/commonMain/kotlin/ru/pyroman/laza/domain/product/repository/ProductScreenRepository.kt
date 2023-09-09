package ru.pyroman.laza.domain.product.repository

import ru.pyroman.laza.base.divkit.domain.model.ScreenData

interface ProductScreenRepository {

    suspend fun getProductScreenData(): ScreenData
}