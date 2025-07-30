package com.vaskorr.testapp.data.local

import android.content.Context
import com.vaskorr.testapp.data.consts.DataConsts

class PreferencesManager(
    context: Context
) {
    private val prefs =
        context.getSharedPreferences(DataConsts.APP_PREFERENCES, Context.MODE_PRIVATE)

    fun saveString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    fun getString(key: String): String = prefs.getString(key, "") ?: ""

}