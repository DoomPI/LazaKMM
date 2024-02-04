package ru.pyroman.laza.base.divkit.domain.model

import com.yandex.div2.DivData

class AndroidScreenData(
    val divData: DivData,
) : ScreenData

val ScreenData.androidScreenData
    get() = this as AndroidScreenData