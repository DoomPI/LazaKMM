package ru.pyroman.laza.base.divkit.data.parser

import ru.pyroman.laza.base.divkit.domain.model.ScreenData

expect class ScreenDataParser {

    fun parse(jsonString: String): ScreenData
}