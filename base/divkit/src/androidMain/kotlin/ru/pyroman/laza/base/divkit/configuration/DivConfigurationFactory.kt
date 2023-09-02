package ru.pyroman.laza.base.divkit.configuration

import android.content.Context
import com.yandex.div.core.DivActionHandler
import com.yandex.div.core.DivConfiguration
import ru.pyroman.laza.base.divkit.imageloader.DivImageLoaderFactory

internal class DivConfigurationFactory(
    private val imageLoaderFactory: DivImageLoaderFactory,
) {

    fun create(context: Context): DivConfiguration {
        return DivConfiguration.Builder(
            imageLoaderFactory.create(context)
        ).actionHandler(DivActionHandler()).build()
    }
}