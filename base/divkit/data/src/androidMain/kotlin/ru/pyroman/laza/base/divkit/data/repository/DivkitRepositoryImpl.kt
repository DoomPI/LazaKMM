package ru.pyroman.laza.base.divkit.data.repository

import com.yandex.div2.DivData
import org.json.JSONObject
import ru.pyroman.laza.base.divkit.data.datasource.network.DivkitNetworkDataSource
import ru.pyroman.laza.base.divkit.data.parser.DivDataParser
import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.base.divkit.domain.repository.DivkitRepository

internal actual class DivkitRepositoryImpl(
    private val parser: DivDataParser,
    private val networkDataSource: DivkitNetworkDataSource,
) : DivkitRepository {
    actual override suspend fun getScreenData(path: String): ScreenData {
        val jsonObject = JSONObject(networkDataSource.getScreenData(path))

        val divData = getDivData(jsonObject)

        return ScreenData(
            divData = divData
        )
    }

    private fun getDivData(jsonObject: JSONObject): DivData? {
        val divan = with(jsonObject) {
            optJSONObject("divan")
        }

        return divan?.let {
            parser.parse(divan)
        }
    }
}