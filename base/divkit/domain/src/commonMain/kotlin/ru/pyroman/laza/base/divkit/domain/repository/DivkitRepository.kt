package ru.pyroman.laza.base.divkit.domain.repository

import ru.pyroman.laza.base.divkit.domain.model.ScreenData

interface DivkitRepository {

    suspend fun getScreenData(path: String): ScreenData
}