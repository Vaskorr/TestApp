package com.vaskorr.testapp.domain.usecase.data

import com.vaskorr.testapp.domain.model.PurchaseList
import com.vaskorr.testapp.domain.repository.DataRepository

class GetPurchasesUseCase(
    private val dataRepository: DataRepository
) {
    operator fun invoke(): PurchaseList {
        return dataRepository.getPurchases()
    }
}