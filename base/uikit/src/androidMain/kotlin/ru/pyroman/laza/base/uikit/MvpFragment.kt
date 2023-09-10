package ru.pyroman.laza.base.uikit

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.pyroman.laza.base.uikit.mvp.MvpPresenter
import ru.pyroman.laza.base.uikit.mvp.MvpView
import ru.pyroman.laza.base.uikit.mvp.mvpDelegate

abstract class MvpFragment : Fragment(), MvpView {

    abstract fun providePresenter(): MvpPresenter<MvpView>

    private val mvpDelegate = mvpDelegate { providePresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mvpDelegate.onCreate()
    }

    override fun onStart() {
        super.onStart()
        mvpDelegate.onAttach(this)
    }

    override fun onResume() {
        super.onResume()
        mvpDelegate.onAttach(this)
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