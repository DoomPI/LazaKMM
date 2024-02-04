package ru.pyroman.laza.base.divkit.data.repository

import ru.pyroman.laza.base.divkit.data.datasource.network.DivkitNetworkDataSource
import ru.pyroman.laza.base.divkit.data.parser.ScreenDataParser
import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.base.divkit.domain.repository.DivkitRepository

internal class DivkitRepositoryImpl(
    private val parser: ScreenDataParser,
    private val networkDataSource: DivkitNetworkDataSource,
) : DivkitRepository {
    override suspend fun getScreenData(path: String): ScreenData {
        val json = networkDataSource.getScreenData(path)

        return parser.parse(json)
    }
}