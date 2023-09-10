package ru.pyroman.laza.base.divkit.ui.usecases

import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.base.divkit.domain.usecase.GetScreenDataUseCase

internal class DivkitUseCases(
    private val getScreenDataUseCase: GetScreenDataUseCase,
) {

    suspend fun getScreenData(path: String): ScreenData {
        return getScreenDataUseCase.execute(path)
    }
}