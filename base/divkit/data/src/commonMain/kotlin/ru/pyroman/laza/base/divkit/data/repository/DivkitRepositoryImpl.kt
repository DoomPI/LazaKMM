package ru.pyroman.laza.base.divkit.data.repository

import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.base.divkit.domain.repository.DivkitRepository

internal expect class DivkitRepositoryImpl : DivkitRepository {

    override suspend fun getScreenData(path: String): ScreenData
}