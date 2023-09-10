package ru.pyroman.laza.base.divkit.ui.presenter

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.pyroman.laza.base.divkit.ui.usecases.DivkitUseCases
import ru.pyroman.laza.base.divkit.ui.view.DivkitMvpView
import ru.pyroman.laza.base.uikit.presenter.BaseMvpPresenter
import ru.pyroman.laza.common.core.di.Inject.instance

abstract class BaseDivkitPresenter<out View : DivkitMvpView> : BaseMvpPresenter<View>() {

    abstract val screenPath: String

    private val useCases: DivkitUseCases = instance()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        view?.showLoading()

        launchCoroutine(Dispatchers.IO) {
            try {
                val screenData = useCases.getScreenData(screenPath)
                withContext(Dispatchers.Main) {
                    view?.showScreen(screenData)
                }
            } catch (exception: RuntimeException) {
                view?.showError()
            }
        }
    }
}