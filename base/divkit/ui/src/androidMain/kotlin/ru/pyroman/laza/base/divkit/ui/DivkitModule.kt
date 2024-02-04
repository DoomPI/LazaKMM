package ru.pyroman.laza.base.divkit.ui

import org.kodein.di.instance
import ru.pyroman.laza.base.divkit.data.divkitDataModule
import ru.pyroman.laza.base.divkit.ui.configuration.DivConfigurationFactory
import ru.pyroman.laza.base.divkit.ui.context.DivContextProvider
import ru.pyroman.laza.base.divkit.ui.divview.DivViewFactory
import ru.pyroman.laza.base.divkit.ui.divview.DivViewFactoryImpl
import ru.pyroman.laza.base.divkit.ui.imageloader.DivImageLoaderFactory
import ru.pyroman.laza.base.divkit.ui.imageloader.GlideDivImageLoaderFactory
import ru.pyroman.laza.common.core.di.module
import ru.pyroman.laza.common.core.di.provider
import ru.pyroman.laza.common.core.di.singleton
import ru.pyroman.laza.common.core.platform.AndroidPlatformConfiguration
import ru.pyroman.laza.common.core.platform.PlatformConfiguration

actual val divkitModule = module("divkitModule") {
    importAll(
        divkitCommonModule,
        divkitDataModule
    )

    provider<DivImageLoaderFactory> {
        GlideDivImageLoaderFactory()
    }

    provider {
        DivConfigurationFactory(
            imageLoaderFactory = instance()
        )
    }

    singleton {
        val platformConfiguration = instance<PlatformConfiguration>() as AndroidPlatformConfiguration

        DivContextProvider(
            divConfigurationFactory = instance(),
            context = platformConfiguration.androidContext,
        ).provide()
    }

    provider<DivViewFactory> {
        DivViewFactoryImpl(
            context = instance(),
        )
    }
}