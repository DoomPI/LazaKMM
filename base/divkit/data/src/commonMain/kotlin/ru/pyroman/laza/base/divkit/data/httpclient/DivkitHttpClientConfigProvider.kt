package ru.pyroman.laza.base.divkit.data.httpclient

import io.ktor.http.URLProtocol

internal class DivkitHttpClientConfigProvider {

    fun provide(): DivkitHttpClientConfig {
        return DivkitHttpClientConfig(
            host = "10.0.2.2:8080",
            protocol = URLProtocol.HTTP,
        )
    }
}