package ru.pyroman.laza.base.divkit.ui.divview

import android.view.View
import ru.pyroman.laza.base.divkit.domain.model.ScreenData

interface DivViewFactory {

    fun create(screenData: ScreenData): View
}