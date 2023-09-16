package ru.pyroman.laza.base.uikit.mvp

class MvpDelegate<View : MvpView>(
    view: View,
    private val presenterProvider: () -> MvpPresenter<View>,
) {

    private var view: View? = view
    private var presenter: MvpPresenter<View>? = null
    private var isAttached: Boolean = false

    fun onCreate() {
        if (presenter == null) {
            presenter = presenterProvider.invoke()
        }
    }

    fun onAttach() {
        if (!isAttached) {
            view?.let {
                presenter?.attachView(it)
                isAttached = true
            }
        }
    }

    fun onDetach() {
        if (isAttached) {
            view = null
            presenter?.detachView()
            isAttached = false
        }
    }

    fun onDestroy() {
        presenter = null
    }
}