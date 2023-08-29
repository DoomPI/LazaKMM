package ru.pyroman.laza.android

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.yandex.div.DivDataTag
import com.yandex.div.core.Div2Context
import com.yandex.div.core.DivActionHandler
import com.yandex.div.core.DivConfiguration
import com.yandex.div.core.images.BitmapSource
import com.yandex.div.core.images.CachedBitmap
import com.yandex.div.core.images.DivImageDownloadCallback
import com.yandex.div.core.images.DivImageLoader
import com.yandex.div.core.images.LoadReference
import com.yandex.div.core.view2.Div2View
import com.yandex.div.data.DivParsingEnvironment
import com.yandex.div.json.ParsingErrorLogger
import com.yandex.div2.DivData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import ru.pyroman.laza.common.core.di.Inject.instance
import ru.pyroman.laza.domain.product.usecase.GetProductScreenUseCase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getProductScreenUseCase = instance<GetProductScreenUseCase>()
        CoroutineScope(Dispatchers.IO).launch {
            val jsonString = getProductScreenUseCase.execute()
            val divData = with(JSONObject(jsonString)) {
                val templates = getJSONObject("templates")
                val card = getJSONObject("card")
                val environment = DivParsingEnvironment(ParsingErrorLogger.LOG)
                environment.parseTemplates(templates)
                DivData(environment, card)
            }

            withContext(Dispatchers.Main) {
                val divConfig = createDivConfiguration(applicationContext)
                val divContext = Div2Context(
                    baseContext = this@MainActivity,
                    configuration = divConfig,
                )
                val divView = Div2View(divContext)
                findViewById<LinearLayout>(R.id.root).addView(divView)
                divView.setData(divData, DivDataTag("someTag"))
            }
        }
    }

    private fun createDivConfiguration(context: Context) =
        DivConfiguration.Builder(
            GlideDivImageLoader(
                requestManager = lazyOf(Glide.with(context))
            )
        ).actionHandler(DivActionHandler()).build()

    class GlideDivImageLoader(
        private val requestManager: Lazy<RequestManager>,
    ) : DivImageLoader {
        override fun loadImage(
            imageUrl: String,
            callback: DivImageDownloadCallback,
        ): LoadReference {
            val uri = Uri.parse(imageUrl)
            val glide = requestManager.value
            val target = glide
                .asBitmap()
                .load(uri)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .listener(callback.wrap { resource, from -> CachedBitmap(resource, uri, from) })
                .into(NoopTarget())
            return LoadReference { glide.clear(target) }
        }

        override fun loadImage(p0: String, imageView: ImageView): LoadReference =
            error("Must not be used")

        override fun loadImageBytes(
            imageUrl: String,
            callback: DivImageDownloadCallback,
        ): LoadReference {
            val uri = Uri.parse(imageUrl)
            val glide = requestManager.value
            val target = glide
                .asGif()
                .load(uri)
                .listener(
                    callback.wrap { resource, from ->
                        val bytes = ByteArray(resource.buffer.remaining())
                        resource.buffer.get(bytes)
                        CachedBitmap(resource.firstFrame, bytes, uri, from)
                    }
                )
                .into(NoopTarget())
            return LoadReference { glide.clear(target) }
        }

        private fun <T> DivImageDownloadCallback.wrap(
            block: (resource: T, from: BitmapSource) -> CachedBitmap
        ): RequestListener<T> {

            return object : RequestListener<T> {

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<T>,
                    isFirstResource: Boolean
                ): Boolean {
                    onError()
                    return true
                }

                override fun onResourceReady(
                    resource: T & Any,
                    model: Any,
                    target: Target<T>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    val from = when (dataSource) {
                        DataSource.REMOTE -> BitmapSource.NETWORK
                        DataSource.MEMORY_CACHE -> BitmapSource.MEMORY
                        DataSource.DATA_DISK_CACHE,
                        DataSource.RESOURCE_DISK_CACHE,
                        DataSource.LOCAL -> BitmapSource.DISK
                    }
                    onSuccess(block(resource, from))
                    return true
                }
            }
        }

        private class NoopTarget<T : Any> : CustomTarget<T>() {

            override fun onResourceReady(resource: T, transition: Transition<in T>?) = Unit

            override fun onLoadCleared(placeholder: Drawable?) = Unit
        }

    }

}
