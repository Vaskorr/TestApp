package com.vaskorr.testapp.domain.repository

import com.vaskorr.testapp.domain.model.PurchaseList

interface DataRepository {
    fun getPurchases(): PurchaseList
}