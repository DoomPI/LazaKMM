package ru.pyroman.laza.base.divkit.ui.divview

import android.view.View
import ru.pyroman.laza.base.divkit.domain.model.AndroidScreenData

interface DivViewFactory {

    fun create(screenData: AndroidScreenData): View
}