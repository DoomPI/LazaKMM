package ru.pyroman.laza.base.divkit.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.base.divkit.ui.databinding.FragmentDivkitBinding
import ru.pyroman.laza.base.divkit.ui.divview.DivViewFactory
import ru.pyroman.laza.base.divkit.ui.presenter.BaseDivkitPresenter
import ru.pyroman.laza.base.divkit.ui.view.DivkitMvpView
import ru.pyroman.laza.base.uikit.mvp.MvpDelegate
import ru.pyroman.laza.base.uikit.mvp.MvpFragment
import ru.pyroman.laza.common.core.di.Inject.instance

abstract class DivkitFragment : MvpFragment(), DivkitMvpView {

    abstract fun providePresenter(): BaseDivkitPresenter

    @Suppress("LeakingThis")
    override val mvpDelegate = MvpDelegate(
        view = this,
        presenterProvider = ::providePresenter
    )

    private var _binding: FragmentDivkitBinding? = null
    private val binding
        get() = requireNotNull(_binding)

    private val divViewFactory: DivViewFactory = instance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDivkitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showScreen(screenData: ScreenData) {
        val divView = divViewFactory.create(screenData)
        divView?.let { view ->
            with(binding) {
                rootView.removeAllViews()
                rootView.addView(view)
            }
        }
    }

    override fun showLoading() {

    }

    override fun showError() {

    }
}