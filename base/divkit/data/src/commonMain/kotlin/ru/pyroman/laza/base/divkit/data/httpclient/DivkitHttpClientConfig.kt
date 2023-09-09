package ru.pyroman.laza.base.divkit.data.httpclient

import io.ktor.http.URLProtocol

internal class DivkitHttpClientConfig(
    val host: String,
    val protocol: URLProtocol,
)