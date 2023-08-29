package ru.pyroman.laza.android

import PlatformSDK
import android.app.Application
import ru.pyroman.laza.common.core.platform.PlatformConfiguration

class LazaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initPlatformSdk()
    }


    private fun initPlatformSdk() {
        PlatformSDK.init(
            configuration = PlatformConfiguration(applicationContext)
        )
    }
}