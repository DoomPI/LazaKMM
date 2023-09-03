package ru.pyroman.laza.base.divkit.view

import android.view.View
import org.json.JSONObject

interface DivViewFactory {

    fun create(cardJson: JSONObject): View
}