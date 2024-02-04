package ru.pyroman.laza.base.divkit.data.parser

import ru.pyroman.laza.base.divkit.domain.model.ScreenData

interface ScreenDataParser {

    fun parse(jsonString: String): ScreenData
}