package ru.pyroman.laza.base.divkit.domain.usecase

import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.base.divkit.domain.repository.DivkitRepository

class GetScreenDataUseCase internal constructor(
    private val divkitRepository: DivkitRepository
) {

    suspend fun execute(path: String): ScreenData {
        return divkitRepository.getScreenData(path)
    }
}