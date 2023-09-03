package ru.pyroman.laza.base.divkit.context

import android.content.Context
import android.view.ContextThemeWrapper
import com.yandex.div.core.Div2Context
import ru.pyroman.laza.base.uikit.R
import ru.pyroman.laza.base.divkit.configuration.DivConfigurationFactory

internal class DivContextProvider(
    private val divConfigurationFactory: DivConfigurationFactory,
    private val context: Context,
) {

    fun provide(): Div2Context {
        val configuration = divConfigurationFactory.create(context)
        val themeResId = R.style.BaseAppTheme

        return Div2Context(
            baseContext = ContextThemeWrapper(context, themeResId),
            configuration = configuration,
        )
    }
}