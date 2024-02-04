package ru.pyroman.laza.base.divkit.ui.divview

import android.view.View
import com.yandex.div.DivDataTag
import com.yandex.div.core.Div2Context
import com.yandex.div.core.view2.Div2View
import ru.pyroman.laza.base.divkit.domain.model.AndroidScreenData

internal class DivViewFactoryImpl(
    private val context: Div2Context,
) : DivViewFactory {

    override fun create(screenData: AndroidScreenData): View {
        val divData = screenData.divData

        return Div2View(context).apply {
            setData(divData, DivDataTag(divData.logId))
        }
    }
}