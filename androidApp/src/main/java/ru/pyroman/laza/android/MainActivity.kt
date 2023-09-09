package ru.pyroman.laza.android

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.pyroman.laza.base.divkit.view.DivViewFactory
import ru.pyroman.laza.common.core.di.Inject.instance
import ru.pyroman.laza.domain.product.usecase.GetProductScreenUseCase

class MainActivity : AppCompatActivity() {

    private val divViewFactory: DivViewFactory = instance()
    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val getProductScreenUseCase = instance<GetProductScreenUseCase>()
        CoroutineScope(Dispatchers.IO).launch(exceptionHandler) {
            val screenData = getProductScreenUseCase.execute()

            withContext(Dispatchers.Main) {
                val divView = divViewFactory.create(screenData)
                divView?.run {
                    (window.decorView as? ViewGroup)?.addView(this)
                }
            }
        }
    }
}
