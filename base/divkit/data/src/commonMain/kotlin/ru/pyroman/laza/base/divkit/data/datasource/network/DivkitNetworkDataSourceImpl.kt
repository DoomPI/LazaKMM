package ru.pyroman.laza.base.divkit.data.datasource.network

import ru.pyroman.laza.base.divkit.data.httpclient.DivkitHttpClient
import ru.pyroman.laza.base.divkit.data.httpclient.ScreenRequestParams

internal class DivkitNetworkDataSourceImpl(
    private val divkitHttpClient: DivkitHttpClient,
) : DivkitNetworkDataSource {

    override suspend fun getScreenData(path: String): String {
        val requestParams = ScreenRequestParams(
            path = path,
        )
        return divkitHttpClient.getScreen(requestParams)
    }
}