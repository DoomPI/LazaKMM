package ru.pyroman.laza.base.divkit.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.base.divkit.ui.R
import ru.pyroman.laza.base.divkit.ui.divview.DivViewFactory
import ru.pyroman.laza.base.divkit.ui.presenter.BaseDivkitPresenter
import ru.pyroman.laza.base.divkit.ui.view.DivkitMvpView
import ru.pyroman.laza.base.uikit.MvpFragment
import ru.pyroman.laza.common.core.di.Inject.instance

abstract class DivkitFragment : MvpFragment(), DivkitMvpView {

    private val divViewFactory: DivViewFactory = instance()
    abstract override fun providePresenter(): BaseDivkitPresenter<DivkitMvpView>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_divkit, container, false)
    }

    override fun showScreen(screenData: ScreenData) {
        val divView = divViewFactory.create(screenData)
        divView?.run {
            val root = findViewById<FrameLayout>(R.id.rootView)
            root.removeAllViews()
            root.addView(this)
        }
    }

    override fun showLoading() {

    }

    override fun showError() {

    }
}