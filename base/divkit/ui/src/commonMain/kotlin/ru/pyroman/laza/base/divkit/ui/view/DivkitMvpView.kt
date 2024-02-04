package ru.pyroman.laza.base.divkit.ui.view

import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.mvpkmp.MvpView

interface DivkitMvpView : MvpView {

    fun showScreen(screenData: ScreenData)

    fun showLoading()

    fun showError()

    fun showNetworkError()
}