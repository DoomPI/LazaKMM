package ru.pyroman.laza.base.uikit.mvp

class MvpDelegate<View : MvpView>(
    private val presenterProvider: () -> MvpPresenter<View>
) {

    private var presenter: MvpPresenter<View>? = null
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