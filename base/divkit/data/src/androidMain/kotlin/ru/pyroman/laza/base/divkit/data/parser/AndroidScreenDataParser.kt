package ru.pyroman.laza.base.divkit.data.parser

import com.yandex.div.data.DivParsingEnvironment
import com.yandex.div.json.ParsingErrorLogger
import com.yandex.div2.DivData
import org.json.JSONObject
import ru.pyroman.laza.base.divkit.domain.model.AndroidScreenData
import ru.pyroman.laza.base.divkit.domain.model.ScreenData

class AndroidScreenDataParser : ScreenDataParser {

    private val environment = DivParsingEnvironment(ParsingErrorLogger.ASSERT)

    override fun parse(jsonString: String): ScreenData {

        val json = JSONObject(jsonString)
        val divan = with(json) {
            getJSONObject("divan")
        }
        val card = divan.getJSONObject("card")
        val templates = divan.optJSONObject("templates")
        if (templates != null) {
            environment.parseTemplates(templates)
        }

        return AndroidScreenData(
            divData = DivData(environment, card)
        )
    }
}