package ru.pyroman.laza.base.divkit.data.datasource.network

internal interface DivkitNetworkDataSource {

    suspend fun getScreenData(path: String): String
}