package ru.pyroman.laza.base.divkit.ui.view.args

import ru.pyroman.laza.common.navigation.ViewArgs

expect class DivkitViewArgs(
    query: String
) : ViewArgs {
    val query: String
}