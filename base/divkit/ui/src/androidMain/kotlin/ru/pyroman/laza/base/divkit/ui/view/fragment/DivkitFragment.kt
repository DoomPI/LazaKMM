package ru.pyroman.laza.base.divkit.ui.view.fragment

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.parcelize.Parcelize
import ru.pyroman.laza.base.divkit.ui.view.DivkitViewArgs
import ru.pyroman.laza.base.divkit.domain.model.ScreenData
import ru.pyroman.laza.base.divkit.ui.databinding.FragmentDivkitBinding
import ru.pyroman.laza.base.divkit.ui.divview.DivViewFactory
import ru.pyroman.laza.base.divkit.ui.presenter.DivkitPresenterFactory
import ru.pyroman.laza.base.divkit.ui.view.DivkitMvpView
import ru.pyroman.laza.base.divkit.ui.view.fragment.DivkitFragment.Companion.Arguments.Companion.toParcelableArgs
import ru.pyroman.laza.base.divkit.ui.view.fragment.DivkitFragment.Companion.Arguments.Companion.toViewArgs
import ru.pyroman.laza.base.uikit.mvp.MvpDelegate
import ru.pyroman.laza.base.uikit.mvp.MvpFragment
import ru.pyroman.laza.base.uikit.utils.parcelableArg
import ru.pyroman.laza.common.core.di.Inject.instance

class DivkitFragment : MvpFragment(), DivkitMvpView {

    override val mvpDelegate = MvpDelegate(
        view = this,
        presenterProvider = {
            divkitPresenterFactory.create(
                viewArgs = args.toViewArgs(),
            )
        }
    )

    private var _binding: FragmentDivkitBinding? = null
    private val binding
        get() = requireNotNull(_binding)

    private val divViewFactory: DivViewFactory = instance()

    private val divkitPresenterFactory: DivkitPresenterFactory = instance()

    private val args by parcelableArg<Arguments>(ARGUMENTS)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDivkitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showScreen(screenData: ScreenData) {
        val divView = divViewFactory.create(screenData)

        with(binding) {
            rootView.removeAllViews()
            rootView.addView(divView)
        }
    }

    override fun showLoading() {

    }

    override fun showError() {

    }

    override fun showNetworkError() {

    }

    companion object {
        private const val ARGUMENTS = "arguments"

        fun withArgs(viewArgs: DivkitViewArgs): Bundle {
            val fragmentArgs = viewArgs.toParcelableArgs()

            return Bundle().apply {
                putParcelable(ARGUMENTS, fragmentArgs)
            }
        }

        @Parcelize
        class Arguments(
            val screenPath: String
        ) : Parcelable {
            companion object {
                fun Arguments.toViewArgs(): DivkitViewArgs {
                    return DivkitViewArgs(
                        path = screenPath,
                    )
                }
                fun DivkitViewArgs.toParcelableArgs(): Arguments {
                    return Arguments(
                        screenPath = path,
                    )
                }
            }
        }
    }
}