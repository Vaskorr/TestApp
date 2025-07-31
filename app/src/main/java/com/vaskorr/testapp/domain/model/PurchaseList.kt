package com.vaskorr.testapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PurchaseList(
    val data: List<PurchaseItem>
)