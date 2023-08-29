package ru.pyroman.laza.domain.product.usecase

import ru.pyroman.laza.domain.product.repository.ProductScreenRepository

class GetProductScreenUseCase(
    private val productScreenRepository: ProductScreenRepository,
) {

    suspend fun execute(): String {
        return productScreenRepository.getProductScreenData()
    }
}