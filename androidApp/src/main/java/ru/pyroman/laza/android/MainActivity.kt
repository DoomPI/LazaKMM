package ru.pyroman.laza.android

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import ru.pyroman.laza.base.divkit.view.DivViewFactory
import ru.pyroman.laza.common.core.di.Inject.instance
import ru.pyroman.laza.domain.product.usecase.GetProductScreenUseCase

class MainActivity : AppCompatActivity() {

    private val divViewFactory: DivViewFactory = instance()
    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getProductScreenUseCase = instance<GetProductScreenUseCase>()
        CoroutineScope(Dispatchers.IO).launch(exceptionHandler) {
            val jsonString = getProductScreenUseCase.execute()
            val card = with(JSONObject(jsonString)) {
                getJSONObject("card")
            }

            withContext(Dispatchers.Main) {
                val divView = divViewFactory.create(card)
                findViewById<LinearLayout>(R.id.root).addView(divView)
            }
        }
    }
}
