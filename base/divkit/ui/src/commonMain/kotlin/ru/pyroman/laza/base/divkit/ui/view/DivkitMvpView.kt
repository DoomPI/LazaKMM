package ru.pyroman.laza.base.divkit.ui.view

import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.base.uikit.mvp.MvpView

interface DivkitMvpView : MvpView {

    fun showScreen(screenData: ScreenData)

    fun showLoading()

    fun showError()
}