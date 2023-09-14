package ru.pyroman.laza.base.uikit

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.pyroman.laza.base.uikit.mvp.MvpDelegate
import ru.pyroman.laza.base.uikit.mvp.MvpPresenter
import ru.pyroman.laza.base.uikit.mvp.MvpView

abstract class MvpFragment<View : MvpView> : Fragment() {

    protected abstract fun provideView(): View

    protected abstract fun providePresenter(): MvpPresenter<View>

    protected abstract val mvpDelegate: MvpDelegate<View, MvpPresenter<View>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mvpDelegate.onCreate()
    }

    override fun onStart() {
        super.onStart()
        mvpDelegate.onAttach(provideView())
    }

    override fun onStop() {
        super.onStop()
        mvpDelegate.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
        mvpDelegate.onDestroy()
    }
}