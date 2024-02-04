package ru.pyroman.laza.base.divkit.data

import org.kodein.di.instance
import ru.pyroman.laza.base.divkit.data.datasource.network.DivkitNetworkDataSource
import ru.pyroman.laza.base.divkit.data.datasource.network.DivkitNetworkDataSourceImpl
import ru.pyroman.laza.base.divkit.data.httpclient.DivkitHttpClient
import ru.pyroman.laza.base.divkit.data.httpclient.DivkitHttpClientConfigProvider
import ru.pyroman.laza.base.divkit.data.repository.DivkitRepositoryImpl
import ru.pyroman.laza.base.divkit.domain.repository.DivkitRepository
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.provider
import ru.pyroman.laza.common.core.di.singleton

internal val divkitDataCommonModule = module("divkitDataCommonModule") {

    singleton {
        DivkitHttpClientConfigProvider().provide()
    }

    singleton {
        DivkitHttpClient(
            httpClient = instance(),
            config = instance(),
        )
    }

    provider<DivkitNetworkDataSource> {
        DivkitNetworkDataSourceImpl(
            divkitHttpClient = instance(),
        )
    }

    provider<DivkitRepository> {
        DivkitRepositoryImpl(
            parser = instance(),
            networkDataSource = instance(),
        )
    }
}