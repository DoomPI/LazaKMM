package ru.pyroman.laza.base.divkit.data.parser

import com.yandex.div.data.DivParsingEnvironment
import com.yandex.div.json.ParsingErrorLogger
import com.yandex.div2.DivData
import org.json.JSONObject

internal class DivDataParser {

    fun parse(json: JSONObject): DivData {
        val environment = DivParsingEnvironment(ParsingErrorLogger.ASSERT)
        val card = json.getJSONObject("card")
        val templates = json.optJSONObject("templates")
        if (templates != null) {
            environment.parseTemplates(templates)
        }

        return DivData(environment, card)
    }
}