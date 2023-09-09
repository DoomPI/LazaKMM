package ru.pyroman.laza.data.product.repository

import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.base.divkit.domain.repository.DivkitRepository
import ru.pyroman.laza.domain.product.repository.ProductScreenRepository

internal class ProductScreenRepositoryImpl(
    private val divkitRepository: DivkitRepository
) : ProductScreenRepository {

    override suspend fun getProductScreenData(): ScreenData {
        return divkitRepository.getScreenData(
            path = PATH,
        )
    }

    companion object {
        private const val PATH = "product"
    }
}