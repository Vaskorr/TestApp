package com.vaskorr.testapp.data.local

import android.content.Context
import com.vaskorr.testapp.R


class JsonDataProvider(
    private val context: Context
) {
    fun getJsonData(): String {
        return context.resources.openRawResource(R.raw.data) // Типа с сервера получили, в тз не было конкретики) Если надо - могу и файрбейз допилить
            .bufferedReader()
            .use { it.readText() }
    }
}