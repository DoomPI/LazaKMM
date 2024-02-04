package ru.pyroman.laza.base.divkit.ui.view.controller

import platform.UIKit.UIViewController
import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.base.divkit.ui.presenter.DivkitPresenterFactory
import ru.pyroman.laza.base.divkit.ui.view.DivkitMvpView
import ru.pyroman.laza.base.divkit.ui.view.args.DivkitViewArgs
import ru.pyroman.laza.common.core.di.Inject
import ru.pyroman.mvpkmp.MvpDelegate.Companion.mvpDelegate

class DivkitViewController(
    private val args: DivkitViewArgs,
): UIViewController(), DivkitMvpView {

    private val mvpDelegate = mvpDelegate {
        divkitPresenterFactory.create(
            viewArgs = args,
        )
    }

    private val divkitPresenterFactory: DivkitPresenterFactory = Inject.instance()

    override fun viewDidLoad() {
        super.viewDidLoad()
        mvpDelegate.onCreate()
    }

    override fun viewWillAppear(animated: Boolean) {
        super.viewWillAppear(animated)
        mvpDelegate.onAttach()
    }

    override fun viewDidDisappear(animated: Boolean) {
        super.viewDidDisappear(animated)
        mvpDelegate.onDetach()
    }

    override fun viewDidUnload() {
        super.viewDidUnload()
        mvpDelegate.onDestroy()
    }
    override fun showScreen(screenData: ScreenData) {

    }

    override fun showLoading() {

    }

    override fun showError() {

    }

    override fun showNetworkError() {

    }
}