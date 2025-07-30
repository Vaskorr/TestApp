package com.vaskorr.testapp.data.util

import kotlinx.serialization.json.Json

class JsonConverter {
    val jsonParser = Json { ignoreUnknownKeys = true }

    inline fun <reified T> parseJson(jsonString: String): T {
        return jsonParser.decodeFromString<T>(jsonString)
    }
}