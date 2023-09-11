package ru.pyroman.laza.base.divkit.ui.presenter

import ru.pyroman.laza.base.divkit.ui.usecases.DivkitUseCases
import ru.pyroman.laza.base.divkit.ui.view.DivkitMvpView
import ru.pyroman.laza.base.uikit.presenter.BaseMvpPresenter
import ru.pyroman.laza.common.core.di.Inject.instance

abstract class BaseDivkitPresenter : BaseMvpPresenter<DivkitMvpView>() {

    abstract val screenPath: String

    private val useCases: DivkitUseCases = instance()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        view?.showLoading()

        launch(
            block = {
                useCases.getScreenData(screenPath)
            },
            onSuccess = { screenData ->
                view?.showScreen(screenData)
            },
            onError = { _, _ ->
                view?.showError()
            }
        )
    }
}