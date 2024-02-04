package ru.pyroman.laza.base.divkit.data

import ru.pyroman.laza.base.divkit.data.parser.AndroidScreenDataParser
import ru.pyroman.laza.base.divkit.data.parser.ScreenDataParser
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.provider

actual val divkitDataModule = module("divkitDataModule") {
    importAll(
        divkitDataCommonModule
    )

    provider<ScreenDataParser> {
        AndroidScreenDataParser()
    }
}