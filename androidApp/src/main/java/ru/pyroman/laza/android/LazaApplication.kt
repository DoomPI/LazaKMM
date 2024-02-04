package ru.pyroman.laza.android

import android.app.Application
import ru.pyroman.laza.common.core.platform.AndroidPlatformConfiguration
import ru.pyroman.laza.common.umbrella.platform.PlatformSDK

class LazaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initPlatformSdk()
    }


    private fun initPlatformSdk() {
        PlatformSDK.initPlatform(
            configuration = AndroidPlatformConfiguration(applicationContext)
        )
    }
}