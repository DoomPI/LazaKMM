package ru.pyroman.laza.base.divkit

import org.kodein.di.instance
import ru.pyroman.laza.common.core.di.provider
import ru.pyroman.laza.common.core.di.singleton
import ru.pyroman.laza.base.divkit.configuration.DivConfigurationFactory
import ru.pyroman.laza.base.divkit.context.DivContextProvider
import ru.pyroman.laza.base.divkit.imageloader.DivImageLoaderFactory
import ru.pyroman.laza.base.divkit.imageloader.GlideDivImageLoaderFactory
import ru.pyroman.laza.base.divkit.view.DivViewFactory
import ru.pyroman.laza.base.divkit.view.DivViewFactoryImpl
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.platform.PlatformConfiguration

actual val divkitModule = module("divkitModule") {

    provider<DivImageLoaderFactory> {
        GlideDivImageLoaderFactory()
    }

    provider {
        DivConfigurationFactory(
            imageLoaderFactory = instance()
        )
    }

    singleton {
        val platformConfiguration: PlatformConfiguration = instance()

        DivContextProvider(
            divConfigurationFactory = instance(),
            context = platformConfiguration.androidContext,
        ).provide()
    }

    provider<DivViewFactory> {
        DivViewFactoryImpl(
            context = instance(),
            templatesJson = null,
        )
    }
}