package ru.pyroman.laza.feature.product.presenter

import ru.pyroman.laza.base.divkit.ui.presenter.BaseDivkitPresenter
import ru.pyroman.laza.feature.product.view.ProductView

class ProductPresenter : BaseDivkitPresenter<ProductView>() {
    override val screenPath: String
        get() = "product"
}