package ru.pyroman.laza.base.divkit.ui.view.args

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class AndroidDivkitViewArgs(
    override val query: String,
) : DivkitViewArgs, Parcelable