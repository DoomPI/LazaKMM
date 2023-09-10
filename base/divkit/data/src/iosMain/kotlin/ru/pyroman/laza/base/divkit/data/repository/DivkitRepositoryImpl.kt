package ru.pyroman.laza.base.divkit.data.repository

import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.base.divkit.domain.repository.DivkitRepository

internal actual class DivkitRepositoryImpl : DivkitRepository {

    actual override suspend fun getScreenData(path: String): ScreenData {
        TODO()
    }
}