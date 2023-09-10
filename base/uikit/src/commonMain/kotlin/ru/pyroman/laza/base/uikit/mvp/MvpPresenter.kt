package ru.pyroman.laza.base.uikit.mvp

import ru.pyroman.laza.common.core.utils.ref.WeakReference

open class MvpPresenter<out View : MvpView> {

    protected val view: View?
        get() = _view?.get()

    private var _view: WeakReference<View>? = null
    private var isFirstLaunch = true

    protected open fun onFirstViewAttach() {

    }

    open fun attachView(view: @UnsafeVariance View) {
        this._view = WeakReference(view)

        if (isFirstLaunch) {
            isFirstLaunch = false
            onFirstViewAttach()
        }
    }

    open fun detachView() {
        this._view?.clear()
    }
}