package ru.pyroman.laza.feature.product.view

import ru.pyroman.laza.base.divkit.ui.presenter.BaseDivkitPresenter
import ru.pyroman.laza.base.divkit.ui.view.fragment.DivkitFragment
import ru.pyroman.laza.feature.product.presenter.ProductPresenter

class ProductFragment : DivkitFragment() {

    override val view = this

    override fun providePresenter(): BaseDivkitPresenter {
        return ProductPresenter()
    }
}