package ru.pyroman.laza.base.divkit.ui.presenter

import ru.pyroman.laza.base.divkit.ui.view.args.DivkitViewArgs

class DivkitPresenterFactory {

    fun create(viewArgs: DivkitViewArgs): DivkitPresenter {
        return DivkitPresenter(
            viewArgs = viewArgs
        )
    }
}