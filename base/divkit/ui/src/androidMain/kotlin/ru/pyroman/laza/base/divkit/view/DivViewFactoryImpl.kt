package ru.pyroman.laza.base.divkit.view

import android.view.View
import com.yandex.div.DivDataTag
import com.yandex.div.core.Div2Context
import com.yandex.div.core.view2.Div2View
import ru.pyroman.laza.base.divkit.domain.model.ScreenData

internal class DivViewFactoryImpl(
    private val context: Div2Context,
) : DivViewFactory {

    override fun create(screenData: ScreenData): View? {
        val divData = screenData.divData

        return divData?.let { data ->
            Div2View(context).apply {
                setData(data, DivDataTag(data.logId))
            }
        }
    }
}