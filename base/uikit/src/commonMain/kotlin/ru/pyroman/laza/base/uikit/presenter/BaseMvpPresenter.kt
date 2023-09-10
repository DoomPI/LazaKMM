package ru.pyroman.laza.base.uikit.presenter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.pyroman.laza.base.uikit.mvp.MvpPresenter
import ru.pyroman.laza.base.uikit.mvp.MvpView
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

open class BaseMvpPresenter<out View : MvpView> : MvpPresenter<View>() {

    private val coroutineScopeDelegate = lazy {
        CoroutineScope(
            context = Dispatchers.Main.immediate
                    + SupervisorJob()
        )
    }

    private val coroutineScope by coroutineScopeDelegate

    protected fun launchCoroutine(
        context: CoroutineContext = EmptyCoroutineContext,
        block: suspend CoroutineScope.() -> Unit,
    ): Job {
        return coroutineScope.launch(context) { block() }
    }
}