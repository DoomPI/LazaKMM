package ru.pyroman.laza.base.divkit.ui

import ru.pyroman.laza.common.core.di.module

actual val divkitModule = module("divkitModule") {
    importAll(
        divkitCommonModule
    )
}