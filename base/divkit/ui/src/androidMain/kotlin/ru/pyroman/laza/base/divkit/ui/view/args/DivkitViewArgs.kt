package ru.pyroman.laza.base.divkit.ui.view.args

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.pyroman.laza.common.navigation.ViewArgs

@Parcelize
actual class DivkitViewArgs actual constructor(
    actual val query: String,
) : ViewArgs, Parcelable