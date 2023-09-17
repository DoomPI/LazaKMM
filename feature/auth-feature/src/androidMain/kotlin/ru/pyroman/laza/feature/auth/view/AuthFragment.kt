package ru.pyroman.laza.feature.auth.view

import ru.pyroman.laza.base.divkit.ui.view.fragment.BaseDivkitFragment
import ru.pyroman.laza.common.core.di.Inject.instance
import ru.pyroman.laza.feature.auth.presenter.AuthPresenter

class AuthFragment : BaseDivkitFragment() {

    override fun providePresenter() = instance<AuthPresenter>()
}