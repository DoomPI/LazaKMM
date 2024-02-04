package ru.pyroman.laza.base.divkit.data

import ru.pyroman.laza.common.core.di.module

actual val divkitDataModule = module("divkitDataModule") {
    importAll(
        divkitDataCommonModule
    )
}