package ru.pyroman.laza.base.divkit

import org.kodein.di.instance
import ru.pyroman.laza.common.core.di.provider
import ru.pyroman.laza.base.divkit.configuration.DivConfigurationFactory
import ru.pyroman.laza.base.divkit.imageloader.DivImageLoaderFactory
import ru.pyroman.laza.base.divkit.imageloader.GlideDivImageLoaderFactory
import ru.pyroman.laza.common.core.di.module

val divkitModule = module("divkitModule") {

    provider<DivImageLoaderFactory> {
        GlideDivImageLoaderFactory()
    }

    provider<DivConfigurationFactory> {
        DivConfigurationFactory(
            imageLoaderFactory = instance()
        )
    }
}