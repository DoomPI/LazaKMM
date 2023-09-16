package ru.pyroman.laza.feature.product.view

import ru.pyroman.laza.base.divkit.ui.view.fragment.BaseDivkitFragment
import ru.pyroman.laza.common.core.di.Inject.instance
import ru.pyroman.laza.feature.product.presenter.ProductPresenter

class ProductFragment : BaseDivkitFragment() {

    override fun providePresenter() = instance<ProductPresenter>()
}