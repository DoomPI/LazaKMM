package ru.pyroman.laza.base.uikit.mvp

class MvpDelegate<View : MvpView, Presenter : MvpPresenter<View>>(
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
}