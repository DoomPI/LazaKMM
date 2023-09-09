package ru.pyroman.laza.base.divkit.data

import org.kodein.di.instance
import ru.pyroman.laza.base.divkit.data.parser.DivDataParser
import ru.pyroman.laza.base.divkit.data.repository.DivkitRepositoryImpl
import ru.pyroman.laza.base.divkit.domain.repository.DivkitRepository
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.provider

actual val divkitDataModule = module("divkitDataModule") {
    importAll(
        divkitCommonDataModule
    )

    provider {
        DivDataParser()
    }

    provider<DivkitRepository> {
        DivkitRepositoryImpl(
            parser = instance(),
            networkDataSource = instance(),
        )
    }
}