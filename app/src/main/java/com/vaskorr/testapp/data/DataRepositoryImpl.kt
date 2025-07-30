package com.vaskorr.testapp.data

import com.vaskorr.testapp.data.local.JsonDataProvider
import com.vaskorr.testapp.data.util.JsonConverter
import com.vaskorr.testapp.domain.model.PurchaseList
import com.vaskorr.testapp.domain.repository.DataRepository

class DataRepositoryImpl(
    private val jsonDataProvider: JsonDataProvider,
    private val jsonConverter: JsonConverter
) : DataRepository {
    override fun getPurchases(): PurchaseList {
        val jsonString = jsonDataProvider.getJsonData()
        return jsonConverter.parseJson<PurchaseList>(jsonString)
    }
}