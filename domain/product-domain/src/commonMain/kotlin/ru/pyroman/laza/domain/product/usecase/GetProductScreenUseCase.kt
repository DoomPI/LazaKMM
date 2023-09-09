package ru.pyroman.laza.domain.product.usecase

import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.domain.product.repository.ProductScreenRepository

class GetProductScreenUseCase(
    private val productScreenRepository: ProductScreenRepository,
) {

    suspend fun execute(): ScreenData {
        return productScreenRepository.getProductScreenData()
    }
}