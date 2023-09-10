package ru.pyroman.laza.base.uikit.mvp

import kotlin.reflect.KProperty

class MvpDelegate<in View : MvpView, out Presenter : MvpPresenter<*>>(
    private val presenterProvider: () -> Presenter
) {

    private var presenter: Presenter? = null
    private var isAttached: Boolean = false

    fun onCreate() {
        if (presenter == null) {
            presenter = presenterProvider.invoke()
        }
    }

    fun onAttach(view: View) {
        if (!isAttached) {
            presenter?.attachView(view)
            isAttached = true
        }
    }

    fun onDetach() {
        if (isAttached) {
            presenter?.detachView()
            isAttached = false
        }
    }

    fun onDestroy() {
        presenter = null
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Presenter {
        return presenter ?: throw IllegalStateException(
            "Presenter has to be initialized in onCreate()"
        )
    }
}

inline fun <View : MvpView, Presenter : MvpPresenter<View>> mvpDelegate(
    noinline provider: () -> Presenter,
): MvpDelegate<View, Presenter> {
    return MvpDelegate(provider)
}